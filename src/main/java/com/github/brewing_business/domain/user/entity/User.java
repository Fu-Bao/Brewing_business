package com.github.brewing_business.domain.user.entity;

import jakarta.persistence.*;

@Entity(name = "user")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long idx;
}
