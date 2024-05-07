package com.github.brewing_business.domain.product.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReqProductDto {
    private String name;
    private String description;
    private int price;
    private int quantity;
    private String category;
}
