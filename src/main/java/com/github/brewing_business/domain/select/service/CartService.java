package com.github.brewing_business.domain.select.service;

import com.github.brewing_business.domain.product.entity.ProductEntity;
import com.github.brewing_business.domain.product.repository.ProductRepository;
import com.github.brewing_business.domain.select.dto.ReqCartProductDto;
import com.github.brewing_business.domain.select.entity.cart.CartEntity;
import com.github.brewing_business.domain.select.entity.cart.CartProductEntity;
import com.github.brewing_business.domain.select.repository.CartProductRepository;
import com.github.brewing_business.domain.select.repository.CartRepository;
import com.github.brewing_business.domain.user.entity.UserEntity;
import com.github.brewing_business.domain.user.repository.UserRepository;
import com.github.brewing_business.exception.AppException;
import com.github.brewing_business.exception.ErrorCode;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final CartProductRepository cartProductRepository;

    // 장바구니 생성 & 장바구니에 상품 추가
    @Transactional
    public void addCart(ReqCartProductDto cartProductDto, String email){
        ProductEntity product = productRepository.findById(cartProductDto.getProduct_id())
                .orElseThrow(EntityNotFoundException::new);
        UserEntity user = userRepository.findByEmail(email).orElseThrow(
                () -> new AppException(ErrorCode.USER_EMAIL_NOT_FOUND.getMessage(), ErrorCode.USER_EMAIL_NOT_FOUND)
        );

        CartEntity cart = cartRepository.findByUser_Idx(user.getIdx());

        // 장바구니가 없다면 생성
        if (cart == null) {
            cart = CartEntity.toCartEntity(user);
            cartRepository.save(cart);
        }

        // 장바구니에 상품 추가하기
        CartProductEntity cartProduct = cartProductRepository.findByCartIdxAndProduct_Idx(cart.getIdx(), product.getIdx());
        Integer price = product.getPrice();
        Integer count = cartProductDto.getCount();

        if (cartProduct == null) {
            cartProduct = CartProductEntity.addFromCartProduct(cart, product, price, count);
            cartProductRepository.save(cartProduct);
        } else {
            cartProduct.addCount(count);
        }
    }
}
