package com.dacs.beshop.mapper;

import com.dacs.beshop.dto.response.AddressResponseDto;
import com.dacs.beshop.entities.Address;

public class AddressMapper {
    public static AddressResponseDto toAddressDto(Address address) {
        return AddressResponseDto.builder()
                .id(address.getAddressId())
                .country(address.getCountry())
                .province(address.getProvince())
                .district(address.getDistrict())
                .commune(address.getCommune())
                .addressLine(address.getAddressLine())
                .phoneNumber(address.getPhoneNumber())
                .isDefault(address.isDefault())
                .build();
    }
}
