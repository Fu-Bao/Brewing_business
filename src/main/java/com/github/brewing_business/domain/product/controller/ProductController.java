package com.github.brewing_business.domain.product.controller;

import com.github.brewing_business.domain.product.dto.ResProductDto;
import com.github.brewing_business.domain.product.entity.Product;
import com.github.brewing_business.domain.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<List<ResProductDto>> getAllProduct() {

        List<ResProductDto> product = productService.findAllProduct();

        return ResponseEntity.ok().body(product);
    }

}
