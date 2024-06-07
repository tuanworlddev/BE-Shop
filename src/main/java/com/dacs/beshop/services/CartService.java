package com.dacs.beshop.services;

import com.dacs.beshop.dto.request.CartRequestDto;
import com.dacs.beshop.entities.Cart;

import java.util.List;

public interface CartService {
    List<Cart> getCartsByUser(Integer userId);
    void addCart(CartRequestDto cartRequestDto);
}
