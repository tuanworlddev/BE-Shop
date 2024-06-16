package com.dacs.beshop.repositories;

import com.dacs.beshop.entities.OrderDetails;
import com.dacs.beshop.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
    List<OrderItem> findOrderItemsByOrderDetails(OrderDetails orderDetails);
}
