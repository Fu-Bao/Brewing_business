package com.github.brewing_business.domain.user.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Role {

    USER("user"),
    ADMIN("admin"),
    SELLER("seller");

    private final String roleName;
}
