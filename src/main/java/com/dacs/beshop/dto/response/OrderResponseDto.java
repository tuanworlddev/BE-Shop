package com.dacs.beshop.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class OrderResponseDto {
    private Integer id;
    private Double total;
    private String status;
    private List<OrderItemResponseDto> items;
    private AddressResponseDto address;
}
