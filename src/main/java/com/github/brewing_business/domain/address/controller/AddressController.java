package com.github.brewing_business.domain.address.controller;

import com.github.brewing_business.domain.address.dto.AddressDto;
import com.github.brewing_business.domain.address.service.AddressService;
import com.github.brewing_business.domain.auth.entity.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("")
public class AddressController {

    private final AddressService addressService;

    @PostMapping("/v1/add/address")
    public ResponseEntity<AddressDto> addAddress(@RequestBody AddressDto addressDto, @AuthenticationPrincipal CustomUserDetails user) {
        String userId = user.getUsername();
        AddressDto address = addressService.addAddress(addressDto, userId);

        return ResponseEntity.ok().body(address);
    }
}
