package com.github.brewing_business.domain.product.dto;


import com.github.brewing_business.domain.product.entity.ProductEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResProductDto {
    private String name;
    private String description;
    private int price;
    private int quantity;
    private String category;
    private Double star_rating;

    public static ResProductDto toResponse(ProductEntity productEntity) {
        return ResProductDto.builder()
                .name(productEntity.getName())
                .description(productEntity.getDescription())
                .price(productEntity.getPrice())
                .quantity(productEntity.getQuantity())
                .category(productEntity.getCategory())
                .star_rating(productEntity.getStar_rating())
                .build();
    }
}
