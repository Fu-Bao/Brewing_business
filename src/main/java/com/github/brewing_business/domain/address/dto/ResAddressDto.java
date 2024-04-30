package com.github.brewing_business.domain.address.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResAddressDto {
    private String message;
    private String username;
    private AddressDto address;
}
