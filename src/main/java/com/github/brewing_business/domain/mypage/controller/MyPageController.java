package com.github.brewing_business.domain.mypage.controller;

import com.github.brewing_business.domain.auth.entity.CustomUserDetails;
import com.github.brewing_business.domain.mypage.dto.MyPageMainDto;
import com.github.brewing_business.domain.mypage.service.MyPageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("")
@Tag(name = "유저 마이페이지 관련 API", description = "마이페이지 관련 api 컨트롤러")
public class MyPageController {

    private final MyPageService myPageService;

    @GetMapping("/v1/my-page")
    @Operation(summary = "유저의 마이페이지를 확인하는 API")
    public ResponseEntity<MyPageMainDto> myPageMain(@AuthenticationPrincipal CustomUserDetails user) {
        String email = user.getUsername();
        MyPageMainDto pageMainDto = myPageService.getMyPage(email);

        return ResponseEntity.ok().body(pageMainDto);
    }

}
