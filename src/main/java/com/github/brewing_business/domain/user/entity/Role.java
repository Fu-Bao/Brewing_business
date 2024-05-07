package com.github.brewing_business.domain.user.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Role {

    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN"),
    SELLER("ROLE_SELLER");

    private final String roleName;
}
