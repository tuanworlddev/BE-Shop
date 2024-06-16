package com.dacs.beshop.mapper;

import com.dacs.beshop.dto.response.OrderResponseDto;
import com.dacs.beshop.entities.OrderDetails;

public class OrderMapper {
    public static OrderResponseDto toOrderResponseDto(OrderDetails orderDetails) {
        return OrderResponseDto.builder()
                .id(orderDetails.getId())
                .total(orderDetails.getTotal())
                .status(orderDetails.getStatus().name())
                .items(orderDetails.getItems().stream().map(OrderItemMapper::toOrderItemRequestDto).toList())
                .build();
    }
}
