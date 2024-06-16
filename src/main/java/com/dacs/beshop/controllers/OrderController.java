package com.dacs.beshop.controllers;

import com.dacs.beshop.dto.request.OrderDetailsRequestDto;
import com.dacs.beshop.dto.request.UpdateOrderStateDto;
import com.dacs.beshop.dto.response.OrderResponseDto;
import com.dacs.beshop.dto.response.ResponseDto;
import com.dacs.beshop.entities.OrderStatus;
import com.dacs.beshop.mapper.OrderMapper;
import com.dacs.beshop.services.OrderDetailsService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderDetailsService orderDetailsService;

    public OrderController(OrderDetailsService orderDetailsService) {
        this.orderDetailsService = orderDetailsService;
    }

    @GetMapping
    public List<OrderResponseDto> getAllOrders() {
        return orderDetailsService.getAllOrderDetails().stream().map(OrderMapper::toOrderResponseDto).toList();
    }

    @GetMapping("/user")
    public List<OrderResponseDto> getOrders() {
        return orderDetailsService.getOrderDetails().stream().map(OrderMapper::toOrderResponseDto).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDto> getOrder(@PathVariable Integer id) {
        return ResponseEntity.ok(OrderMapper.toOrderResponseDto(orderDetailsService.getOrderDetails(id)));
    }

    @PostMapping
    public ResponseEntity<ResponseDto> createOrder(@Valid @RequestBody OrderDetailsRequestDto orderDetailsRequestDto) {
        orderDetailsService.addOrderDetails(orderDetailsRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(HttpStatus.CREATED.value(), "Order created successfully"));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResponseDto> updateStatus(@PathVariable Integer id, @RequestBody UpdateOrderStateDto updateOrderStateDto) {
        orderDetailsService.updateStatus(id, OrderStatus.valueOf(updateOrderStateDto.getStatus()));
        return ResponseEntity.ok(new ResponseDto(HttpStatus.OK.value(), "Order updated successfully"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteOrder(@PathVariable Integer id) {
        orderDetailsService.deleteOrderDetails(id);
        return ResponseEntity.ok(new ResponseDto(HttpStatus.OK.value(), "Order deleted successfully"));
    }
}
