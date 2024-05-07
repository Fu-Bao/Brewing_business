package com.github.brewing_business.domain.user.controller;

import com.github.brewing_business.domain.auth.entity.CustomUserDetails;
import com.github.brewing_business.domain.user.dto.MyProfileDto;
import com.github.brewing_business.domain.user.dto.ResProfileDto;
import com.github.brewing_business.domain.user.dto.SignupDto;
import com.github.brewing_business.domain.user.service.UserService;
import com.github.brewing_business.exception.ErrorCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("")
@Slf4j
@Tag(name = "유저 관련 API", description = "유저 서비스 관련 api 컨트롤러")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    @Operation(summary = "아이디, 비밀번호, 유저네임으로 회원가입을 처리하는 API 엔드포인트")
    public ResponseEntity<?> signup(@Valid @RequestBody SignupDto signupDto, BindingResult bindingResult) throws Exception {
        log.info("회원가입 진입");
        if(bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(ErrorCode.BINDING_RESULT_ERROR.getMessage());
        }
  
        userService.signup(signupDto);
        return ResponseEntity.ok("회원가입 성공");
    }

    @GetMapping("/v1/my-page")
    @Operation(summary = "유저의 마이페이지를 확인하는 API")
    public ResponseEntity<MyProfileDto> myPageMain(@AuthenticationPrincipal CustomUserDetails user) {
        String email = user.getUsername();
        MyProfileDto pageMainDto = userService.getMyPage(email);

        return ResponseEntity.ok().body(pageMainDto);
    }

    @PutMapping("/v1/update/profile")
    @Operation(summary = "유저의 프로필을 수정하는 API")
    public ResponseEntity<?> updateProfile(@Valid @RequestBody MyProfileDto profileDto, BindingResult bindingResult, @AuthenticationPrincipal CustomUserDetails user) {
        if(bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(ErrorCode.BINDING_RESULT_ERROR.getMessage());
        }

        String email = user.getUsername();
        ResProfileDto resProfileDto = userService.updateMyProfile(email, profileDto);

        return ResponseEntity.ok().body(resProfileDto);
    }
}
