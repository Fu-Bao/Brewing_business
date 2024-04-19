package com.github.brewing_business.domain.product.dto;

import com.github.brewing_business.domain.product.entity.Product;
import com.github.brewing_business.domain.product.entity.ProductImage;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResProductDto {

    private String name;
    private String description;
    private int price;
    private int count;
    private String category;
    private List<String> imgURL;
    private double gpa; // 별점 : grade point average

    public static ResProductDto toResponse(Product product) {

        List<String> imgList = product
                .getImgURLs()
                .stream()
                .map(ProductImage::getImgUrl)
                .toList();

        return ResProductDto.builder()
                .name(product.getName())
                .description(product.getDescription())
                .count(product.getQuantity())
                .price(product.getPrice())
                .category(product.getCategory())
                .gpa(product.getRating())
                .imgURL(imgList)
                .build();
    }

}
