package com.github.brewing_business.domain.user.controller;

import com.github.brewing_business.domain.user.dto.SignupDto;
import com.github.brewing_business.domain.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping
@Tag(name = "유저 관련 API", description = "유저 서비스 관련 api 컨트롤러")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    @Operation(summary = "이메일, 비밀번호, 유저네임으로 회원가입을 처리하는 API 엔드포인트")
    public ResponseEntity<?> signup(SignupDto signupDto) {
        userService.signup(signupDto);
        return ResponseEntity.ok("회원가입 성공");
    }
}
