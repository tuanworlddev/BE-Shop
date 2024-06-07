package com.dacs.beshop.services;

import com.dacs.beshop.dto.request.CartItemRequestDto;
import com.dacs.beshop.entities.Cart;

public interface CartItemService {
    void addCartItem(Cart cart, CartItemRequestDto cartItemRequestDto);
}
