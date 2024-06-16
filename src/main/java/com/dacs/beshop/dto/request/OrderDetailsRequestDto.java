package com.dacs.beshop.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderDetailsRequestDto {
    @NotNull
    private Integer addressId;
    @NotNull
    private Double total;
    @NotNull
    private List<OrderItemRequestDto> orderItems;
}
