package com.github.brewing_business.domain.address.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResAddressDto {
    private String message;
    private String username;
    private AddressDto address;
}
