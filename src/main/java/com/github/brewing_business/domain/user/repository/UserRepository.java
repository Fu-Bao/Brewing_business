package com.github.brewing_business.domain.user.repository;

import com.github.brewing_business.domain.user.dto.SignupDto;
import com.github.brewing_business.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByUsername(String username);

    boolean existsByUserId(String userId);

    Optional<User> findByRefreshToken(String refreshToken);

    Optional<User> findByUsername(String username);

    Optional<User> findByUserId(String userId);

}
