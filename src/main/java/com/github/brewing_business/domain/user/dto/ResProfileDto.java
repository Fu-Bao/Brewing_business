package com.github.brewing_business.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResProfileDto {
    private String message;
    private MyProfileDto profile;
}
