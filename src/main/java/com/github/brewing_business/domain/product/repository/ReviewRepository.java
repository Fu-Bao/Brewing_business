package com.github.brewing_business.domain.product.repository;

import com.github.brewing_business.domain.product.entity.ProductEntity;
import com.github.brewing_business.domain.product.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {

    @Query(value = "SELECT AVG(star_rating) FROM review WHERE product_idx = :productIdx", nativeQuery = true)
    Double getAverageStarRatingByProductId(@Param("productIdx") Long productIdx);

    Optional<ReviewEntity> findByProduct(ProductEntity product);
}
