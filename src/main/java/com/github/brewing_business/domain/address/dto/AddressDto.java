package com.github.brewing_business.domain.address.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

    private String phone_number;
    private String address1;
    private String address2;
    private String zipcode;
    private boolean is_default;
}
