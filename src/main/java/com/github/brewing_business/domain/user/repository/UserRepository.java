package com.github.brewing_business.domain.user.repository;

import com.github.brewing_business.domain.user.dto.SignupDto;
import com.github.brewing_business.domain.user.entity.Role;
import com.github.brewing_business.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    Optional<User> findByRefreshToken(String refreshToken);

    Optional<User> findByEmail(String userId);
}
