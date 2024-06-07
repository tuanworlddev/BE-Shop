package com.dacs.beshop.controllers;

import com.dacs.beshop.dto.request.CartRequestDto;
import com.dacs.beshop.dto.response.CartResponseDto;
import com.dacs.beshop.dto.response.ResponseDto;
import com.dacs.beshop.mapper.CartMapper;
import com.dacs.beshop.services.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carts")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/user/{id}")
    public List<CartResponseDto> getCartsByUser(@PathVariable("id") Integer userId) {
        return cartService.getCartsByUser(userId).stream().map(CartMapper::toCartDto).toList();
    }

    @PostMapping()
    public ResponseEntity<ResponseDto> addCart(@RequestBody CartRequestDto cartRequestDto) {
        cartService.addCart(cartRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(HttpStatus.CREATED.value(), "Cart created successfully"));
    }
}
