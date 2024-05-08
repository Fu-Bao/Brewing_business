package com.github.brewing_business.domain.user.repository;

import com.github.brewing_business.domain.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    Optional<UserEntity> findByRefreshToken(String refreshToken);

    Optional<UserEntity> findByEmail(String userId);
}
