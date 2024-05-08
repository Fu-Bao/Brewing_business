package com.github.brewing_business.domain.product.dto;

import com.github.brewing_business.domain.product.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private String name;
    private String description;
    private int price;
    private int quantity;
    private String category;
    private String region;

    public ProductDto(ProductEntity product) {
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.quantity = product.getQuantity();
        this.category = product.getCategory();
        this.region = product.getRegion();
    }
}
