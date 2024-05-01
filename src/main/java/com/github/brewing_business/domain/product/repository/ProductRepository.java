package com.github.brewing_business.domain.product.repository;

import com.github.brewing_business.domain.product.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findAllByCategory(String category);

    List<ProductEntity> findAllByRegion(String region);

    List<ProductEntity> findAllByIdx(Long id);

    Optional<List<ProductEntity>> findAllByNameContaining(String name);
}
