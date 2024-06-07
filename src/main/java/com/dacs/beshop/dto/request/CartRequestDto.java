package com.dacs.beshop.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
public class CartRequestDto {
    private Integer userId;
    private Double total;
    private List<CartItemRequestDto> cartItems;
}
