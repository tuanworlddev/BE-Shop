package com.dacs.beshop.services.impl;

import com.dacs.beshop.config.SecurityUtil;
import com.dacs.beshop.dto.request.AddressRequestDto;
import com.dacs.beshop.entities.Address;
import com.dacs.beshop.entities.User;
import com.dacs.beshop.exceptions.NotAuthenticatedException;
import com.dacs.beshop.exceptions.NotFoundException;
import com.dacs.beshop.repositories.AddressRepository;
import com.dacs.beshop.services.AddressService;
import com.dacs.beshop.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final UserService userService;

    public AddressServiceImpl(AddressRepository addressRepository, UserService userService) {
        this.addressRepository = addressRepository;
        this.userService = userService;
    }

    @Override
    public List<Address> getAddresses() {
        return addressRepository.findAddressByUser(getCurrentUser());
    }

    @Override
    public Address getAddressById(Integer id) {
        return addressRepository.findById(id).orElseThrow(() -> new NotFoundException("Address not found"));
    }


    @Override
    public void addAddress(AddressRequestDto addressRequestDto) {
        Address address = Address.builder()
                .user(getCurrentUser())
                .country(addressRequestDto.getCountry())
                .province(addressRequestDto.getProvince())
                .district(addressRequestDto.getDistrict())
                .commune(addressRequestDto.getCommune())
                .addressLine(addressRequestDto.getAddressLine())
                .phoneNumber(addressRequestDto.getPhoneNumber())
                .isDefault(addressRequestDto.getIsDefault())
                .build();
        addressRepository.save(address);
    }

    @Override
    public void updateAddress(Integer id, AddressRequestDto addressRequestDto) {
        Address address = getAddressById(id);
        address.setCountry(addressRequestDto.getCountry());
        address.setProvince(addressRequestDto.getProvince());
        address.setDistrict(addressRequestDto.getDistrict());
        address.setCommune(addressRequestDto.getCommune());
        address.setAddressLine(addressRequestDto.getAddressLine());
        address.setPhoneNumber(addressRequestDto.getPhoneNumber());
        address.setDefault(addressRequestDto.getIsDefault());
        addressRepository.save(address);
    }

    private User getCurrentUser() {
        String userEmail = SecurityUtil.getCurrentEmail();
        if (userEmail != null) {
            return userService.getUserByEmail(userEmail);
        }
        throw new NotAuthenticatedException("Not authenticated");
    }
}
