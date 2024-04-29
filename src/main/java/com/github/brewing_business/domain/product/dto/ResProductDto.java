package com.github.brewing_business.domain.product.dto;


import com.github.brewing_business.domain.product.entity.ProductEntity;
import com.github.brewing_business.domain.product.entity.ProductImgEntity;
import com.github.brewing_business.domain.product.entity.ReviewEntity;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResProductDto {
    private Long idx;
    private String name;
    private String description;
    private int price;
    private int quantity;
    private String category;
    private String region;
    private Double star_rating;
    private List<String> productImgList;
    private List<ReviewEntity> reviewList;


    public static ResProductDto toResponse(ProductEntity productEntity) {
        List<String> productImgList = new ArrayList<>();
        List<ReviewEntity> reviewEntityList = new ArrayList<>();
        productImgList = productEntity.getProductImgEntitiesList()
                .stream()
                .map(ProductImgEntity::getImgPath).toList();
        return ResProductDto.builder()
                .idx(productEntity.getIdx())
                .name(productEntity.getName())
                .description(productEntity.getDescription())
                .price(productEntity.getPrice())
                .quantity(productEntity.getQuantity())
                .category(productEntity.getCategory())
                .region(productEntity.getRegion())
                .star_rating(productEntity.getStar_rating())
                .productImgList(productImgList)
                .reviewList(reviewEntityList)
                .build();
    }
}
