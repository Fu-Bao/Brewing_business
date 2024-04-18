package com.github.brewing_business.domain.product.entity;

import com.github.brewing_business.domain.product.dto.ReqProductDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "product")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

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

    @Column(name = "star_rating")
    private double rating;

    public static Product toEntity(ReqProductDto reqProductDto) {
        return Product.builder().build();
    }
}
