package com.github.brewing_business.domain.select.controller;

import com.github.brewing_business.domain.auth.entity.CustomUserDetails;
import com.github.brewing_business.domain.select.dto.ReqCartProductDto;
import com.github.brewing_business.domain.select.service.CartService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
@Tag(name = "장바구니 관련 API", description = "장바구니 관련 api 컨트롤러")
public class CartController {

    private final CartService cartService;

    // 장바구니에 담기
    @PostMapping("/cart")
    @Operation(summary = "유저가 장바구니에 상품을 담는 API")
    public ResponseEntity<?> addCart(
            @Valid @RequestBody ReqCartProductDto cartItemRequestDto,
            @AuthenticationPrincipal CustomUserDetails customUserDetails,
            BindingResult bindingResult){

        // binding 에러 시
        if(bindingResult.hasErrors()){
            StringBuilder sb = new StringBuilder();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();

            for (FieldError fieldError : fieldErrors) {
                sb.append(fieldError.getDefaultMessage());
            }

            return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
        }

        String email = customUserDetails.getUsername();

        try {
            cartService.addCart(cartItemRequestDto, email);
        } catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok("해당 상품을 장바구니에 추가하였습니다.");
    }
}
