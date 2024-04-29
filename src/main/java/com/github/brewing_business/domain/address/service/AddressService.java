package com.github.brewing_business.domain.address.service;

import com.github.brewing_business.domain.address.dto.ResAddressDto;
import com.github.brewing_business.domain.address.dto.AddressDto;
import com.github.brewing_business.domain.address.entity.AddressEntity;
import com.github.brewing_business.domain.address.repository.AddressRepository;
import com.github.brewing_business.domain.user.entity.User;
import com.github.brewing_business.domain.user.repository.UserRepository;
import com.github.brewing_business.exception.AppException;
import com.github.brewing_business.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final UserRepository userRepository;

    @Transactional
    public ResAddressDto addAddress(AddressDto addressDto, String userId) {
        User user = userRepository.findByUserId(userId).orElseThrow(
                () -> new AppException(ErrorCode.USER_ID_NOT_FOUND.getMessage(), ErrorCode.USER_ID_NOT_FOUND)
        );

        AddressEntity address = AddressEntity.toEntity(user, addressDto);

        if (addressDto.getIsDefault()) user.setDefaultAddress(address);

        addressRepository.save(address);

        return new ResAddressDto("배송지가 등록되었습니다.", user.getUsername(), addressDto);
    }

    @Transactional
    public ResAddressDto updateAddress(Long addressIdx, AddressDto modifiedAddress, String userId) {
        User user = userRepository.findByUserId(userId).orElseThrow(
                () -> new AppException(ErrorCode.USER_ID_NOT_FOUND.getMessage(), ErrorCode.USER_ID_NOT_FOUND)
        );

        AddressEntity address = addressRepository.findById(addressIdx).orElseThrow(
                () -> new AppException(ErrorCode.ADDRESS_NOT_FOUND.getMessage(), ErrorCode.ADDRESS_NOT_FOUND)
        );

        if (modifiedAddress.getIsDefault()) user.setDefaultAddress(address);

        address.update(modifiedAddress);

        return new ResAddressDto("배송지가 수정되었습니다.", user.getUsername(), modifiedAddress);
    }
}
