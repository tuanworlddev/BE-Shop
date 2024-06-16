package com.dacs.beshop.services;

import com.dacs.beshop.dto.request.AddressRequestDto;
import com.dacs.beshop.entities.Address;
import com.dacs.beshop.entities.User;

import java.util.List;

public interface AddressService {
    List<Address> getAddresses();
    Address getAddressById(Integer id);
    void addAddress(AddressRequestDto addressRequestDto);
    void updateAddress(Integer id, AddressRequestDto addressRequestDto);
}
