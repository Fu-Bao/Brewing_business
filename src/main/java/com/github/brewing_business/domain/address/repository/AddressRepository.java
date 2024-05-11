package com.github.brewing_business.domain.address.repository;

import com.github.brewing_business.domain.address.entity.AddressEntity;
import com.github.brewing_business.domain.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

    List<AddressEntity> findAllByUser(UserEntity userEntity);
}
