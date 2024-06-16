package com.dacs.beshop.services;

import com.dacs.beshop.dto.request.OrderItemRequestDto;
import com.dacs.beshop.entities.OrderDetails;
import com.dacs.beshop.entities.OrderItem;

import java.util.List;

public interface OrderItemService {
    void addOrderItem(OrderDetails orderDetails, OrderItemRequestDto orderItemDto);
}
