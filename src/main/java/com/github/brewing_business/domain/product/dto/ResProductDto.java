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
    private int quantity;
    private String category;
    private Double star_avg;

//    public static ResProductDto toResponse(Product productEntity){
//        return ResProductDto.builder()
//                .category()
//                .build();
//    }
}
