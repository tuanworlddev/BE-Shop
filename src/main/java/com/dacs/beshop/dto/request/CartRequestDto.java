package com.dacs.beshop.dto.request;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CartRequestDto {
    private Integer userId;
    private Double total;
    private List<CartItemRequestDto> cartItems;
}
