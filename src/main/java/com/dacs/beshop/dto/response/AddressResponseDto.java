package com.dacs.beshop.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AddressResponseDto {
    private Integer id;
    private String country;
    private String province;
    private String district;
    private String commune;
    private String addressLine;
    private String phoneNumber;
    private Boolean isDefault;
}
