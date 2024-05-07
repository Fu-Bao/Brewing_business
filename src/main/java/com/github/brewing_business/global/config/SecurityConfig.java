package com.github.brewing_business.global.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.brewing_business.domain.auth.handler.LoginFailureHandler;
import com.github.brewing_business.domain.auth.handler.LoginSuccessHandler;
import com.github.brewing_business.domain.auth.handler.LogoutSuccessHandler;
import com.github.brewing_business.domain.auth.service.CustomUserDetailService;
import com.github.brewing_business.domain.user.repository.UserRepository;
import com.github.brewing_business.global.filter.CustomUsernamePasswordAuthenticationFilter;
import com.github.brewing_business.global.filter.JwtAuthenticationFilter;
import com.github.brewing_business.global.jwt.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutFilter;

import java.util.Collection;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final ObjectMapper objectMapper;
    private final CustomUserDetailService customUserDetailService;
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final LogoutSuccessHandler logoutSuccessHandler;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                // 현재 페이지에서만 프레임을 허용하고 다른 출처의 프레임은 차단, Clickjacking 공격을 방지
                .headers(httpSecurityHeadersConfigurer -> httpSecurityHeadersConfigurer.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin))
                // csrf 공격 방어 X
                .csrf(AbstractHttpConfigurer::disable)
                // form 로그인 X
                .formLogin(AbstractHttpConfigurer::disable)
                // http basic 인증 방식 X
                .httpBasic(AbstractHttpConfigurer::disable)
                // 사용자가 로그인한 후에도 브라우저를 닫았다가 다시 열어도 자동으로 로그인 상태를 유지 X
                .rememberMe(AbstractHttpConfigurer::disable)
                // 세션 X
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // 접근 권한 설정
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/test/**").permitAll()
                        .requestMatchers("/v1/**").hasRole("USER") // v1 경로는 인증된 유저 등급 이상 접근 가능
                        .requestMatchers("/v2/**").hasRole("SELLER") // v2 경로는 판매자 등급 이상 접근 가능
                        .requestMatchers("/v3/**").hasRole("ADMIN") // v3 경로는 관리자만 접근 가능
                        .anyRequest().permitAll())
                // 로그아웃 설정
                .logout((logout) -> logout
                        .logoutUrl("/logout").permitAll()
                        .addLogoutHandler(logoutSuccessHandler)
                        .logoutSuccessHandler(((request, response, authentication) -> SecurityContextHolder.clearContext()))
                        .invalidateHttpSession(true)
                );

        http.addFilterAfter(customUsernamePasswordAuthenticationFilter(), LogoutFilter.class);
        http.addFilterBefore(jwtAuthenticationFilter(), CustomUsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
  
    //AuthenticationManager Bean 등록
    @Bean
    public AuthenticationManager authenticationManager() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(customUserDetailService);

        return new ProviderManager(provider);
    }

    // BCrypt 암호화 메소드
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public CustomUsernamePasswordAuthenticationFilter customUsernamePasswordAuthenticationFilter() {
        CustomUsernamePasswordAuthenticationFilter customUsernamePasswordLoginFilter
                = new CustomUsernamePasswordAuthenticationFilter(objectMapper);
        customUsernamePasswordLoginFilter.setAuthenticationManager(authenticationManager());
        customUsernamePasswordLoginFilter.setAuthenticationSuccessHandler(loginSuccessHandler());
        customUsernamePasswordLoginFilter.setAuthenticationFailureHandler(loginFailureHandler());
        return customUsernamePasswordLoginFilter;
    }

    @Bean
    public LoginSuccessHandler loginSuccessHandler() {
        return new LoginSuccessHandler(jwtService, userRepository);
    }

    @Bean
    public LoginFailureHandler loginFailureHandler() {
        return new LoginFailureHandler();
    }


    @Bean
    public RoleHierarchy roleHierarchy() {
        // 계층 권한 설정
        RoleHierarchyImpl hierarchy = new RoleHierarchyImpl();

        hierarchy.setHierarchy("ROLE_ADMIN > ROLE_SELLER > ROLE_USER");

        return hierarchy;
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter(jwtService, userRepository);
    }
}
