package com.dacs.beshop.mapper;

import com.dacs.beshop.dto.response.CartItemResponseDto;
import com.dacs.beshop.entities.CartItem;

public class CartItemMapper {
    public static CartItemResponseDto toCartItemDto(CartItem cartItem) {
        return CartItemResponseDto.builder()
                .id(cartItem.getId())
                .product(ProductMapper.toProductDto(cartItem.getProductVariant().getProduct()))
                .price(cartItem.getPrice())
                .quantity(cartItem.getQuantity())
                .variant(ProductVariantMapper.toProductVariantResponseDto(cartItem.getProductVariant()))
                .build();
    }
}
