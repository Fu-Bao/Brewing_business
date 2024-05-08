package com.github.brewing_business.domain.product.controller;


import com.github.brewing_business.domain.product.dto.ReqProductDto;
import com.github.brewing_business.domain.product.dto.ResProductDto;
import com.github.brewing_business.domain.product.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "상품 관련 API", description = "상품 관련 api 컨트롤러")
public class  ProductController {

    private final ProductService productService;

    //메인화면 하단 전체 select
    @GetMapping("/v1/product/all")
    @Operation(summary = "모든 상품을 조회하는 API")
    public ResponseEntity<?> productAll() {
        List<ResProductDto> resProductList = productService.getAllProducts();
        return ResponseEntity.ok().body(resProductList);
    }

    //카테고리별 상품전체
    @GetMapping("/v1/product/category")
    @Operation(summary = "카테고리별 상품 전체 조회하는 API")
    public ResponseEntity<?> productFindCategoryAll(@RequestParam String name){
        List<ResProductDto> resProductDtoList = productService.getAllCategory(name);
        return ResponseEntity.ok().body(resProductDtoList);
    }

    //지역별 상품전체
    @GetMapping("/v1/product/region")
    @Operation(summary = "지역별 상품 전체 조회하는 API")
    public ResponseEntity<?> productFindRegionAll(@RequestParam String name){
        List<ResProductDto> resProductDtoList = productService.getAllRegion(name);
        return ResponseEntity.ok().body(resProductDtoList);
    }

    //상품 인덱스 번호로 찾기
    @GetMapping("/v1/product/id")
    @Operation(summary = "상품 인덱스로 번호로 상품 조회 API")
    public ResponseEntity<?> productFindIdAll(@RequestParam Long id){
        ResProductDto resProductDto = productService.getAllId(id);
        return ResponseEntity.ok().body(resProductDto);
    }

    //제품명으로 찾기
    @GetMapping("/v1/product/search")
    @Operation(summary = "상품 이름 키워드 검색 API")
    public ResponseEntity<?> productFindIdAll(@RequestParam String name){
        List<ResProductDto> resProductDtoList = productService.getSearchName(name);
        return ResponseEntity.ok().body(resProductDtoList);
    }

    // 상품 등록
    @PostMapping("/v2/product/create")
    @Operation(summary = "상품 이름 키워드 검색 API", description = "사업자이상 등급만 등록 가능")
    public ResponseEntity<?> create(@RequestBody ReqProductDto reqProductDto){
        productService.createProduct(reqProductDto);
        return ResponseEntity.ok("상품이 등록되었습니다.");
    }

}
