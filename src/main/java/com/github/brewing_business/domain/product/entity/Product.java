package com.github.brewing_business.domain.product.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx")
    private Long idx;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private int price;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "category")
    private String category;

    @Column(name = "star_avg")
    private Double star_avg;

//    public static Product toEntity() {
//        return Product.builder()
//                .idx(product.getIdx())
//
//                .build()
//    }





}
