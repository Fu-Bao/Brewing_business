package com.github.brewing_business.domain.auth.dto;

import com.github.brewing_business.domain.user.entity.Role;
import com.github.brewing_business.domain.user.entity.User;
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

    public ResLoginDto(User user) {
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.username = user.getUsername();
        this.role = user.getRole();
    }

}
