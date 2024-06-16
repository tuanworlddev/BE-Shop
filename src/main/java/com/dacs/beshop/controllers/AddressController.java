package com.dacs.beshop.controllers;

import com.dacs.beshop.dto.request.AddressRequestDto;
import com.dacs.beshop.dto.response.AddressResponseDto;
import com.dacs.beshop.dto.response.ResponseDto;
import com.dacs.beshop.mapper.AddressMapper;
import com.dacs.beshop.services.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public List<AddressResponseDto> getAddresses() {
        return addressService.getAddresses().stream().map(AddressMapper::toAddressDto).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressResponseDto> getAddress(@PathVariable Integer id) {
        return ResponseEntity.ok(AddressMapper.toAddressDto(addressService.getAddressById(id)));
    }

    @PostMapping
    public ResponseEntity<ResponseDto> createAddress(@RequestBody AddressRequestDto addressRequestDto) {
        addressService.addAddress(addressRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(HttpStatus.CREATED.value(), "Address created successfully"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> updateAddress(@PathVariable Integer id, @RequestBody AddressRequestDto addressRequestDto) {
        addressService.updateAddress(id, addressRequestDto);
        return ResponseEntity.ok(new ResponseDto(HttpStatus.OK.value(), "Address updated successfully"));
    }
}
