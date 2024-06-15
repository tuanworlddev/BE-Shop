package com.dacs.beshop.mapper;

import com.dacs.beshop.dto.response.CartResponseDto;
import com.dacs.beshop.entities.Cart;

public class CartMapper {
    public static CartResponseDto toCartDto(Cart cart) {
        return CartResponseDto.builder()
                .id(cart.getId())
                .variant(ProductVariantMapper.toProductVariantResponseDto(cart.getProductVariant()))
                .quantity(cart.getQuantity())
                .productName(cart.getProductVariant().getProduct().getName())
                .productImage(cart.getProductVariant().getProduct().getImages().getFirst().getUrl())
                .build();
    }
}
