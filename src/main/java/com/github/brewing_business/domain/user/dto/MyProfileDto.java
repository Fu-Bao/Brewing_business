package com.github.brewing_business.domain.user.dto;

import com.github.brewing_business.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MyPageMainDto {

    private String profile_img;
    private String username;
    private String email;
    // 내 활동 관련 필드 추가 예정

    public static MyPageMainDto toMyPageMainDto(User user) {
        return MyPageMainDto.builder()
                .profile_img(user.getProfileImg())
                .username(user.getUsername())
                .email(user.getEmail())
                .build();
    }
}
