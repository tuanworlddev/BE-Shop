package com.dacs.beshop.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class OrderItemResponseDto {
    private Integer id;
    private String productName;
    private String productImage;
    private Integer quantity;
    private ProductVariantResponseDto variant;
}
