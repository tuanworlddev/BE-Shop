package com.dacs.beshop.mapper;

import com.dacs.beshop.dto.response.CartItemResponseDto;
import com.dacs.beshop.dto.response.CartResponseDto;
import com.dacs.beshop.entities.Cart;

public class CartMapper {
    public static CartResponseDto toCartDto(Cart cart) {
        return CartResponseDto.builder()
                .id(cart.getId())
                .total(cart.getTotal())
                .cartItems(cart.getItems().stream().map(CartItemMapper::toCartItemDto).toList())
                .build();
    }
}
