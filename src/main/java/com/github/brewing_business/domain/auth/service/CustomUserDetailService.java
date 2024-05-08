package com.github.brewing_business.domain.auth.service;

import com.github.brewing_business.domain.auth.entity.CustomUserDetails;
import com.github.brewing_business.domain.user.entity.UserEntity;
import com.github.brewing_business.domain.user.repository.UserRepository;
import com.github.brewing_business.exception.AppException;
import com.github.brewing_business.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new AppException(ErrorCode.USER_EMAIL_UNMATCHED.getMessage(), ErrorCode.USER_EMAIL_UNMATCHED));

        return new CustomUserDetails(userEntity);
    }
}
