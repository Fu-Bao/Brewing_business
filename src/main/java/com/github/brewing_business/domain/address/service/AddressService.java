package com.github.brewing_business.domain.address.service;

import com.github.brewing_business.domain.address.dto.AddressDto;
import com.github.brewing_business.domain.address.repository.AddressRepository;
import com.github.brewing_business.domain.user.entity.User;
import com.github.brewing_business.domain.user.repository.UserRepository;
import com.github.brewing_business.exception.AppException;
import com.github.brewing_business.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final UserRepository userRepository;

    public AddressDto addAddress(AddressDto addressDto, String userId) {
        User user = userRepository.findByUserId(userId).orElseThrow(
                () -> new AppException(ErrorCode.USER_ID_NOT_FOUND.getMessage(), ErrorCode.USER_ID_NOT_FOUND)
        );

        

    }
}
