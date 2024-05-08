package com.github.brewing_business.domain.auth.dto;

import com.github.brewing_business.domain.user.entity.Role;
import com.github.brewing_business.domain.user.entity.UserEntity;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResLoginDto {
    private String email;
    private String password;
    private String username;
    private Role role;
    private String accessToken;
    private String refreshToken;

    public ResLoginDto(UserEntity userEntity) {
        this.email = userEntity.getEmail();
        this.password = userEntity.getPassword();
        this.username = userEntity.getUsername();
        this.role = userEntity.getRole();
    }

}
