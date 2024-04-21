package com.github.brewing_business.domain.user.service;

import com.github.brewing_business.domain.user.dto.SignupDto;
import com.github.brewing_business.domain.user.repository.UserRepository;
import com.github.brewing_business.exception.AppException;
import com.github.brewing_business.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public void signup(SignupDto signupDto) {
        // 유저네임 중복 확인
        if (userRepository.findByUsername(signupDto.getUsername()).isPresent()) {
            throw new AppException(ErrorCode.USERNAME_DUPLICATED.getMessage(), ErrorCode.USERNAME_DUPLICATED);
        }
    }
}
