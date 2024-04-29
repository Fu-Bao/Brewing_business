package com.github.brewing_business.domain.address.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

    private String receiver;
    private String recPhone;
    private String addressName;
    private String address;
    private String addressDetail;
    private String zipcode;
    private Boolean isDefault;
}
