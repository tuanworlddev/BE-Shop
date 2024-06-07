package com.dacs.beshop.services;

import com.dacs.beshop.dto.request.CartRequestDto;

public interface CartService {
    void addCart(CartRequestDto cartRequestDto);
}
