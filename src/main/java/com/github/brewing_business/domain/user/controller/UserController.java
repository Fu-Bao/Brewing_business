package com.github.brewing_business.domain.user.controller;

import com.github.brewing_business.domain.user.dto.SignupDto;
import com.github.brewing_business.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(SignupDto signupDto) {
        return ResponseEntity.ok("");
    }

}
