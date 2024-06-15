package com.dacs.beshop.controllers;

import com.dacs.beshop.dto.request.CartRequestDto;
import com.dacs.beshop.dto.request.UpdateCartRequestDto;
import com.dacs.beshop.dto.response.CartResponseDto;
import com.dacs.beshop.dto.response.ResponseDto;
import com.dacs.beshop.mapper.CartMapper;
import com.dacs.beshop.services.CartService;
import jakarta.validation.Valid;
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

    @GetMapping
    public List<CartResponseDto> getCarts() {
        return cartService.getCarts().stream().map(CartMapper::toCartDto).toList();
    }

    @PostMapping
    public ResponseEntity<ResponseDto> createCart(@Valid @RequestBody CartRequestDto cartRequestDto) {
        cartService.addCart(cartRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(HttpStatus.CREATED.value(), "added a product to the cart"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> updateCart(@PathVariable Integer id,@Valid @RequestBody UpdateCartRequestDto updateCartRequestDto) {
        cartService.updateQuantity(id, updateCartRequestDto.getQuantity());
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(HttpStatus.OK.value(), "updated quantity"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteCart(@PathVariable Integer id) {
        cartService.deleteCart(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(HttpStatus.OK.value(), "deleted quantity"));
    }
}
