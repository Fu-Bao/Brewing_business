package com.github.brewing_business.domain.product.dto;

import com.github.brewing_business.domain.product.entity.Product;
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
    private String cnt;
    private String category;
    private double gpa; // 별점 : grade point average

    public static ResProductDto toResponse(Product product) {
        return ResProductDto.builder()
                .name(product.getName())
                .build();
    }

}
