package com.github.brewing_business.domain.mypage.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MyPageEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
}
