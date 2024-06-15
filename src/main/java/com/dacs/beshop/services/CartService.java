package com.dacs.beshop.services;

import com.dacs.beshop.dto.request.CartRequestDto;
import com.dacs.beshop.entities.Cart;

import java.util.List;

public interface CartService {
    List<Cart> getCarts();
    Cart getCartById(Integer id);
    void addCart(CartRequestDto cartRequestDto);
    void updateQuantity(Integer cartId, Integer quantity);
    void deleteCart(Integer cartId);
}
