package com.dacs.beshop.services.impl;

import com.dacs.beshop.dto.request.CartRequestDto;
import com.dacs.beshop.entities.Cart;
import com.dacs.beshop.entities.User;
import com.dacs.beshop.repositories.CartRepository;
import com.dacs.beshop.services.CartItemService;
import com.dacs.beshop.services.CartService;
import com.dacs.beshop.services.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final UserService userService;
    private final CartItemService cartItemService;

    public CartServiceImpl(CartRepository cartRepository, UserService userService, CartItemService cartItemService) {
        this.cartRepository = cartRepository;
        this.userService = userService;
        this.cartItemService = cartItemService;
    }

    @Override
    public List<Cart> getCartsByUser(Integer userId) {
        User user = userService.getUserById(userId);
        return cartRepository.findCartsByUser(user);
    }

    @Override
    public void addCart(CartRequestDto cartRequestDto) {
        User user = userService.getUserById(cartRequestDto.getUserId());
        Cart cart = Cart.builder()
                .user(user)
                .total(cartRequestDto.getTotal())
                .build();
        final Cart cartSave = cartRepository.save(cart);
        cartRequestDto.getCartItems().forEach(cartItem -> cartItemService.addCartItem(cartSave, cartItem));
    }


}
