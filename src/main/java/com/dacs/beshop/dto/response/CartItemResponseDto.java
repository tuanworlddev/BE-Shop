package com.dacs.beshop.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CartItemResponseDto {
    private Integer id;
    private ProductResponseDto product;
    private ProductVariantResponseDto variant;
    private Double price;
    private Integer quantity;
}
