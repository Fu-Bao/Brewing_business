package com.github.brewing_business.domain.address.repository;

import com.github.brewing_business.domain.address.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
}
