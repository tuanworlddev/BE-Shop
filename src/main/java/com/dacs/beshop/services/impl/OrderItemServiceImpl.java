package com.dacs.beshop.services.impl;

import com.dacs.beshop.dto.request.OrderItemRequestDto;
import com.dacs.beshop.entities.OrderDetails;
import com.dacs.beshop.entities.OrderItem;
import com.dacs.beshop.repositories.OrderItemRepository;
import com.dacs.beshop.services.OrderItemService;
import com.dacs.beshop.services.ProductVariantService;
import org.springframework.stereotype.Service;


@Service
public class OrderItemServiceImpl implements OrderItemService {
    private final OrderItemRepository orderItemRepository;
    private final ProductVariantService productVariantService;

    public OrderItemServiceImpl(OrderItemRepository orderItemRepository, ProductVariantService productVariantService) {
        this.orderItemRepository = orderItemRepository;
        this.productVariantService = productVariantService;
    }

    @Override
    public void addOrderItem(OrderDetails orderDetails, OrderItemRequestDto orderItemDto) {
        OrderItem orderItem = OrderItem.builder()
                .orderDetails(orderDetails)
                .productVariant(productVariantService.getProductVariant(orderItemDto.getVariantId()))
                .quantity(orderItemDto.getQuantity())
                .build();
        orderItemRepository.save(orderItem);
    }
}
