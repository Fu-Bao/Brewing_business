package com.github.brewing_business.domain.product.controller;


import com.github.brewing_business.domain.product.dto.ResProductDto;
import com.github.brewing_business.domain.product.service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class  ProductController {

    private final ProductService productService;

    //메인화면 하단 전체 select
    //정상작동 확인
    @GetMapping("/v12/product/all")
    @Tag(name = "상품 관련 API", description = "등록된 전체상품 조회")
    public ResponseEntity<List<ResProductDto>> productAll() {
        List<ResProductDto> resProductList = productService.getAllProducts();
        return ResponseEntity.ok().body(resProductList);
    }

    //카테고리별 상품전체
    @GetMapping("/v12/product/category")
    public ResponseEntity<List<ResProductDto>> productFindCategoryAll(@RequestParam String name){
        List<ResProductDto> resProductDtoList = productService.getAllCategory(name);
        return ResponseEntity.ok().body(resProductDtoList);
    }
    //지역별 상품전체
    @GetMapping("/v12/product/region")
    public ResponseEntity<List<ResProductDto>> productFindRegionAll(@RequestParam String name){
        List<ResProductDto> resProductDtoList = productService.getAllRegion(name);
        return ResponseEntity.ok().body(resProductDtoList);
    }

    //상품 인덱스 번호로 찾기
    @GetMapping("/v12/product/id")
    public ResponseEntity<List<ResProductDto>> productFindIdAll(@RequestParam Long id){
        List<ResProductDto> resProductDtoList = productService.getAllId(id);
        return ResponseEntity.ok().body(resProductDtoList);
    }

    //제품명으로 찾기
    @GetMapping("/v12/product/search")
    public ResponseEntity<List<ResProductDto>> productFindIdAll(@RequestParam String name){
        List<ResProductDto> resProductDtoList = productService.getSearchName(name);
        return ResponseEntity.ok().body(resProductDtoList);
    }

    //

}
