package com.github.brewing_business.domain.address.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

    private String address_name;
    private String receiver;
    private String phone_number;
    private String address;
    private boolean is_default;
}
