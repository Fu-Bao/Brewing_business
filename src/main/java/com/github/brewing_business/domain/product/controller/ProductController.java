package com.github.brewing_business.domain.product.controller;

import com.github.brewing_business.domain.product.dto.ReqProductDto;
import com.github.brewing_business.domain.product.dto.ResProductDto;
import com.github.brewing_business.domain.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<List<ResProductDto>> getAllProduct() {
        List<ResProductDto> product = productService.findAllProduct();
        return ResponseEntity.ok().body(product);
    }

    @PostMapping("/v1/add")
    public ResponseEntity<?> addProduct(@RequestBody ReqProductDto reqProductDto) {
        productService.addProduct(reqProductDto);
        return ResponseEntity.ok().build();
    }

}
