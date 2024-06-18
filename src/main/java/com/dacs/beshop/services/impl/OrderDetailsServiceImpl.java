package com.dacs.beshop.services.impl;

import com.dacs.beshop.config.SecurityUtil;
import com.dacs.beshop.dto.request.OrderDetailsRequestDto;
import com.dacs.beshop.entities.OrderDetails;
import com.dacs.beshop.entities.OrderStatus;
import com.dacs.beshop.entities.User;
import com.dacs.beshop.exceptions.NotAuthenticatedException;
import com.dacs.beshop.exceptions.NotFoundException;
import com.dacs.beshop.repositories.OrderDetailsRepository;
import com.dacs.beshop.services.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {
    private final OrderDetailsRepository orderDetailsRepository;
    private final UserService userService;
    private final OrderItemService orderItemService;
    private final AddressService addressService;
    private final EmailService emailService;

    public OrderDetailsServiceImpl(OrderDetailsRepository orderDetailsRepository, UserService userService, OrderItemService orderItemService, AddressService addressService, EmailService emailService) {
        this.orderDetailsRepository = orderDetailsRepository;
        this.userService = userService;
        this.orderItemService = orderItemService;
        this.addressService = addressService;
        this.emailService = emailService;
    }

    @Override
    public List<OrderDetails> getAllOrderDetails() {
        return orderDetailsRepository.findAll();
    }

    @Override
    public List<OrderDetails> getOrderDetails() {
        return orderDetailsRepository.findOrderDetailsByUser(getCurrentUser());
    }

    @Override
    public OrderDetails getOrderDetails(int orderId) {
        return orderDetailsRepository.findById(orderId).orElseThrow(() -> new NotFoundException("Order not found"));
    }

    @Override
    public void addOrderDetails(OrderDetailsRequestDto orderDetailsRequestDto) {
        OrderDetails orderDetails = OrderDetails.builder()
                .user(getCurrentUser())
                .address(addressService.getAddressById(orderDetailsRequestDto.getAddressId()))
                .total(orderDetailsRequestDto.getTotal())
                .status(OrderStatus.Pending)
                .build();
        final OrderDetails savedOrderDetails = orderDetailsRepository.save(orderDetails);
        orderDetailsRequestDto.getOrderItems().forEach(orderItemRequestDto -> orderItemService.addOrderItem(savedOrderDetails, orderItemRequestDto));
    }

    @Override
    public void deleteOrderDetails(int orderId) {
        if (!orderDetailsRepository.existsById(orderId)) {
            throw new NotFoundException("Order not found");
        }
        orderDetailsRepository.deleteById(orderId);
    }

    @Override
    public void updateStatus(int orderId, OrderStatus orderStatus) {
        OrderDetails orderDetails = getOrderDetails(orderId);
        orderDetails.setStatus(orderStatus);
        orderDetailsRepository.save(orderDetails);
        emailService.sendMessageUpdateStatus(orderDetails.getUser().getEmail(), orderDetails);
    }

    private User getCurrentUser() {
        String userEmail = SecurityUtil.getCurrentEmail();
        if (userEmail != null) {
            return userService.getUserByEmail(userEmail);
        }
        throw new NotAuthenticatedException("Not authenticated");
    }
}
