package com.github.brewing_business.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // BCrypt 암호화 메소드
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

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
                        .requestMatchers("/yangjo/v1/**").authenticated() // v1 경로는 인증된 유저 등급 이상 접근 가능
                        .requestMatchers("/yangjo/v2/**").hasAnyRole("admin", "seller") // v2 경로는 판매자 등급 이상 접근 가능
                        .requestMatchers("/yangjo/v3/**").hasRole("admin") // v3 경로는 관리자만 접근 가능
                        .anyRequest().permitAll())

        ;

        return http.build();
    }

}
