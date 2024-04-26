package com.github.brewing_business.domain.product.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    //메인화면 하단 전체select
    @GetMapping("v1")
    public String all() {

        return "dd";
    }


    //지역별 상품전체
    //카테고리별 상품전체
    //클릭했을때 상품디테일 id 받아서 처리 (리ㅏ뷰테이블이랑 매핑)

}
