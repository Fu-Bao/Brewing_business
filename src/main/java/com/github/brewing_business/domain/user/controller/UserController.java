package com.github.brewing_business.domain.user.controller;

import com.github.brewing_business.domain.user.dto.SignupDto;
import com.github.brewing_business.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(SignupDto signupDto) {
        userService.signup(signupDto);
        return ResponseEntity.ok("회원가입 성공");
    }
}
