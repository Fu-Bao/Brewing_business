package com.github.brewing_business.domain.mypage.service;

import com.github.brewing_business.domain.mypage.dto.MyPageMainDto;
import com.github.brewing_business.domain.mypage.repository.MyPageRepository;
import com.github.brewing_business.domain.user.entity.User;
import com.github.brewing_business.domain.user.repository.UserRepository;
import com.github.brewing_business.exception.AppException;
import com.github.brewing_business.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@RequiredArgsConstructor
public class MyPageService {

    private final UserRepository userRepository;
    private final MyPageRepository myPageRepository;

    public MyPageMainDto getMyPage(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(
                () -> new AppException(ErrorCode.USER_EMAIL_NOT_FOUND.getMessage(), ErrorCode.USER_EMAIL_NOT_FOUND)
        );

        return new MyPageMainDto();
    }
}
