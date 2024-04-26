package com.github.brewing_business.domain.product.entity;

import com.github.brewing_business.domain.product.dto.ReqProductDto;
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
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
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

    @Column(name = "star_rating")
    private Double star_rating;

    public static ProductEntity toEntity(ReqProductDto reqProductDto) {
        return ProductEntity.builder()
                .name(reqProductDto.getName())
                .description(reqProductDto.getDescription())
                .price(reqProductDto.getPrice())
                .quantity(reqProductDto.getQuantity())
                .category(reqProductDto.getCategory())
                .star_rating(0.0)
                .build();
    }


}
