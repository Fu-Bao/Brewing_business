package com.github.brewing_business.domain.product.dto;


import com.github.brewing_business.domain.product.entity.ProductEntity;
import com.github.brewing_business.domain.product.entity.ProductImgEntity;
import com.github.brewing_business.domain.product.entity.ReviewEntity;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResProductDto {
    private Long idx;
    private ProductDto productDto;
    private Double star_rating;
    private List<String> productImgList;
    private List<ReviewEntity> reviewList;




    public static ResProductDto toResponse(ProductEntity productEntity) {
        List<String> productImgList;
        List<ReviewEntity> reviewEntityList;

        productImgList = productEntity.getProductImgEntitiesList()
                .stream()
                .map(ProductImgEntity::getImgPath).toList();

        reviewEntityList = productEntity.getReviewEntities();

        ProductDto product = new ProductDto(productEntity);

        return ResProductDto.builder()
                .idx(productEntity.getIdx())
                .productDto(product)
                .star_rating(productEntity.getStarRating())
                .productImgList(productImgList)
                .reviewList(reviewEntityList)
                .build();
    }
}
