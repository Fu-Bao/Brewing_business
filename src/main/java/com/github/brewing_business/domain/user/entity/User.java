package com.github.brewing_business.domain.user.entity;

import com.github.brewing_business.domain.address.entity.AddressEntity;
import com.github.brewing_business.domain.user.dto.SignupDto;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx")
    private Long idx;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "company")
    private String company;

    @Column(name = "business_number")
    private String businessNum;

    @Column(name = "agree_picu")
    private Boolean picu;

    @Column(name = "agree_promotion")
    private Boolean promotion;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "refresh_token")
    private String refreshToken;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt = null;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AddressEntity> addresses = new ArrayList<>();
  
    // 비밀번호 암호화
    public void passwordEncode(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(this.password);
    }

    // refresh token 주입
    public void initRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public static User SignupToEntity(SignupDto signupDto) {
        return User.builder()
                .userId(signupDto.getId())
                .username(signupDto.getUsername())
                .password(signupDto.getPassword())
                .role(Role.USER)
                .picu(signupDto.isAgreePICU())
                .promotion(signupDto.isAgreePromotion())
                .createdAt(LocalDateTime.now())
                .build();
    }

    // 여러 배송지들 중에서 하나만 기본 배송지 설정
    public void setDefaultAddress(AddressEntity defaultAddress) {
        for (AddressEntity address : addresses) {
            address.setIsDefault(address.equals(defaultAddress));
        }
    }
}
