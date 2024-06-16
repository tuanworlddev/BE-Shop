package com.dacs.beshop.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemRequestDto {
    private Integer variantId;
    private Integer quantity;
}
