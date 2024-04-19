package com.github.brewing_business.domain.product.service;

import com.github.brewing_business.domain.product.dto.ReqProductDto;
import com.github.brewing_business.domain.product.repository.ProductRepository;
import com.github.brewing_business.domain.product.dto.ResProductDto;
import com.github.brewing_business.domain.product.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<ResProductDto> findAllProduct() {
        List<Product> product = productRepository.findAll();

        return product
                .stream()
                .map(ResProductDto::toResponse)
                .collect(Collectors.toList());
    }

    public void addProduct(ReqProductDto reqProductDto) {
        Product product = Product.toEntity(reqProductDto);


        productRepository.save(product);
    }
}
