package com.dacs.beshop.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressRequestDto {
    private String country;
    private String province;
    private String district;
    private String commune;
    private String addressLine;
    private String phoneNumber;
    private Boolean isDefault;
}
