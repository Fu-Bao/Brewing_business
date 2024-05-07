package com.github.brewing_business.domain.product.service;

import com.github.brewing_business.domain.product.dto.ResProductDto;
import com.github.brewing_business.domain.product.entity.ProductEntity;
import com.github.brewing_business.domain.product.entity.ReviewEntity;
import com.github.brewing_business.domain.product.repository.ProductRepository;
import com.github.brewing_business.domain.product.repository.ReviewRepository;
import com.github.brewing_business.exception.AppException;
import com.github.brewing_business.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ReviewRepository reviewRepository;

    public List<ResProductDto> getAllProducts() {
        List<ProductEntity> products = productRepository.findAll();

        return products.stream()
                .map(ResProductDto::toResponse)
                .toList();
    }

    public List<ResProductDto> getAllCategory(String category) {
        List<ProductEntity> products = productRepository.findAllByCategory(category);

        return products.stream().map(ResProductDto::toResponse).toList();
    }

    public List<ResProductDto> getAllRegion(String region) {
        List<ProductEntity> products = productRepository.findAllByRegion(region);

        return products.stream().map(ResProductDto::toResponse).toList();
    }

    public ResProductDto getAllId(Long id) {
        ProductEntity product = productRepository.findAllByIdx(id);

        return ResProductDto.toResponse(product);
    }

    public List<ResProductDto> getSearchName(String name) {
         List<ProductEntity> products = productRepository.findAllByNameContaining(name)
                .orElseThrow(() -> new AppException(ErrorCode.USER_EMAIL_NOT_FOUND.getMessage(), ErrorCode.USER_EMAIL_NOT_FOUND));

        return products.stream().map(ResProductDto::toResponse).toList();
    }

    // 리뷰 별점 초기화
    private void initStarRating(ProductEntity product) {
        Double rating = reviewRepository.getAverageStarRatingByProductId(product.getIdx());
        product.averageStarRating(rating);
    }

}
