package com.github.brewing_business.domain.select.repository;

import com.github.brewing_business.domain.select.entity.cart.CartProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartProductRepository extends JpaRepository<CartProductEntity, Long> {
    CartProductEntity findByCartIdxAndProduct_Idx(Long cartId, Long productId);
}
