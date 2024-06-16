package com.dacs.beshop.services;

import com.dacs.beshop.dto.request.OrderDetailsRequestDto;
import com.dacs.beshop.entities.OrderDetails;
import com.dacs.beshop.entities.OrderStatus;

import java.util.List;

public interface OrderDetailsService {
    List<OrderDetails> getAllOrderDetails();
    List<OrderDetails> getOrderDetails();
    OrderDetails getOrderDetails(int orderId);
    void addOrderDetails(OrderDetailsRequestDto orderDetailsRequestDto);
    void deleteOrderDetails(int orderId);
    void updateStatus(int orderId, OrderStatus orderStatus);
}
