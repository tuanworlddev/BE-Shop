package com.dacs.beshop.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class CartItemRequestDto {
    private Integer variantId;
    private Integer quantity;
    private Double price;
}
