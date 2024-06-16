package com.dacs.beshop.mapper;

import com.dacs.beshop.dto.request.OrderItemRequestDto;
import com.dacs.beshop.dto.response.OrderItemResponseDto;
import com.dacs.beshop.entities.OrderItem;

public class OrderItemMapper {
    public static OrderItemResponseDto toOrderItemRequestDto(OrderItem orderItem) {
        return OrderItemResponseDto.builder()
                .id(orderItem.getId())
                .productName(orderItem.getProductVariant().getProduct().getName())
                .productImage(orderItem.getProductVariant().getProduct().getImages().getFirst().getUrl())
                .quantity(orderItem.getQuantity())
                .variant(ProductVariantMapper.toProductVariantResponseDto(orderItem.getProductVariant()))
                .build();
    }
}
