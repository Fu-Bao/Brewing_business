package com.github.brewing_business.domain.user.service;

import com.github.brewing_business.domain.user.dto.SignupDto;
import com.github.brewing_business.domain.user.entity.User;
import com.github.brewing_business.domain.user.repository.UserRepository;
import com.github.brewing_business.exception.AppException;
import com.github.brewing_business.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder bCryptPasswordEncoder;

    // 회원가입
    @Transactional
    public void signup(SignupDto signupDto) {
        // 유저 name 중복 확인
        if (userRepository.existsByUsername(signupDto.getUsername())) {
            throw new AppException(ErrorCode.USERNAME_DUPLICATED.getMessage(), ErrorCode.USERNAME_DUPLICATED);
        }

        // 유저 id 중복 확인
        if (userRepository.existsByUserId(signupDto.getId())) {
            throw new AppException(ErrorCode.USER_ID_DUPLICATED.getMessage(), ErrorCode.USER_ID_DUPLICATED);
        }

        User user = User.SignupToEntity(signupDto);

        user.passwordEncode(bCryptPasswordEncoder);

        userRepository.save(user);
    }

    // 사업자 등록
    @Transactional
    public void registerBusiness() {

    }
}
