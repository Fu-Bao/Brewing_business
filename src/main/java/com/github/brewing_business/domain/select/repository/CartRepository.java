package com.github.brewing_business.domain.select.repository;

import com.github.brewing_business.domain.select.entity.cart.CartEntity;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Long> {
    CartEntity findByUser_Idx(Long userIdx);
}
