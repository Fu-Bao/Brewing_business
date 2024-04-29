package com.github.brewing_business.domain.product.service;


import com.github.brewing_business.domain.product.dto.ResProductDto;
import com.github.brewing_business.domain.product.entity.ProductEntity;
import com.github.brewing_business.domain.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<ResProductDto> getAllProducts() {
        List<ProductEntity> products = productRepository.findAll();
        return products.stream().map((product) -> ResProductDto.toResponse(product)).toList();
    }

    public List<ResProductDto> getAllCategory(String category) {
        List<ProductEntity> products = productRepository.findAllByCategory(category);
        return products.stream().map((product) -> ResProductDto.toResponse(product)).toList();
    }

    public List<ResProductDto> getAllRegion(String region) {
        List<ProductEntity> products = productRepository.findAllByRegion(region);
        return products.stream().map((product) -> ResProductDto.toResponse(product)).toList();
    }

    public List<ResProductDto> getAllId(Long id) {
        List<ProductEntity> products = productRepository.findAllByIdx(id);
        return products.stream().map((product) -> ResProductDto.toResponse(product)).toList();
    }


}
