package com.github.brewing_business.domain.address.controller;

import com.github.brewing_business.domain.address.dto.ResAddressDto;
import com.github.brewing_business.domain.address.dto.AddressDto;
import com.github.brewing_business.domain.address.service.AddressService;
import com.github.brewing_business.domain.auth.entity.CustomUserDetails;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("")
@Tag(name = "유저 배송지 관련 API", description = "배송지 관련 api 컨트롤러")
public class AddressController {

    private final AddressService addressService;

    // 배송지 등록
    @PostMapping("/v1/address/add")
    @Operation(summary = "배송지 정보를 저장하는 API")
    public ResponseEntity<ResAddressDto> addAddress(@RequestBody AddressDto addressDto, @AuthenticationPrincipal CustomUserDetails user) {
        String userId = user.getUsername();
        ResAddressDto address = addressService.addAddress(addressDto, userId);

        return ResponseEntity.ok().body(address);
    }

    // 배송지 수정
    @PutMapping("/v1/address/{addressId}/update")
    @Operation(summary = "배송지 정보를 수정하는 API")
    public ResponseEntity<ResAddressDto> updateAddress(@PathVariable Long addressId, @RequestBody AddressDto addressDto, @AuthenticationPrincipal CustomUserDetails user) {
        String userId = user.getUsername();
        ResAddressDto address = addressService.updateAddress(addressId, addressDto, userId);

        return ResponseEntity.ok().body(address);
    }
}
