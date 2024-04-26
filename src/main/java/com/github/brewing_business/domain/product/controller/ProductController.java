package com.github.brewing_business.domain.product.controller;


import com.github.brewing_business.domain.product.dto.ResProductDto;
import com.github.brewing_business.domain.product.service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    //메인화면 하단 전체select
    @GetMapping("/v12/product/all")
    @Tag(name = "상품 관련 API", description = "등록된 전체상품 조회")
    public ResponseEntity<List<ResProductDto>> productAll() {
        List<ResProductDto> resProductList = productService.getAllProducts();
        return ResponseEntity.ok().body(resProductList);
    }


    //지역별 상품전체
    //카테고리별 상품전체
    //클릭했을때 상품디테일 id 받아서 처리 (리ㅏ뷰테이블이랑 매핑)

}
