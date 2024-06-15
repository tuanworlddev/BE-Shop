package com.dacs.beshop.services.impl;

import com.dacs.beshop.config.SecurityUtil;
import com.dacs.beshop.dto.request.CartRequestDto;
import com.dacs.beshop.entities.Cart;
import com.dacs.beshop.entities.User;
import com.dacs.beshop.exceptions.NotFoundException;
import com.dacs.beshop.repositories.CartRepository;
import com.dacs.beshop.repositories.UserRepository;
import com.dacs.beshop.services.CartService;
import com.dacs.beshop.services.ProductVariantService;
import com.dacs.beshop.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    private final UserService userService;
    private final CartRepository cartRepository;
    private final ProductVariantService productVariantService;

    public CartServiceImpl(UserService userService, CartRepository cartRepository, ProductVariantService productVariantService) {
        this.userService = userService;
        this.cartRepository = cartRepository;
        this.productVariantService = productVariantService;
    }



    @Override
    public List<Cart> getCarts() {
        String userEmail = SecurityUtil.getCurrentEmail();
        if (userEmail != null) {
            User user = userService.getUserByEmail(userEmail);
            if (user != null) {
                return cartRepository.findCartsByUser(user);
            }
        }
        return List.of();
    }

    @Override
    public Cart getCartById(Integer id) {
        return cartRepository.findById(id).orElseThrow(() -> new NotFoundException("Cart not found"));
    }

    @Override
    public void addCart(CartRequestDto cartRequestDto) {
        String userEmail = SecurityUtil.getCurrentEmail();
        if (userEmail != null) {
            User user = userService.getUserByEmail(userEmail);
            if (user != null) {
                Cart cart = Cart.builder()
                        .user(user)
                        .quantity(cartRequestDto.getQuantity())
                        .productVariant(productVariantService.getProductVariant(cartRequestDto.getVariantId()))
                        .build();
                cartRepository.save(cart);
            }
        }
    }

    @Override
    public void updateQuantity(Integer cartId, Integer quantity) {
        Cart cart = getCartById(cartId);
        cart.setQuantity(quantity);
        cartRepository.save(cart);
    }

    @Override
    public void deleteCart(Integer cartId) {
        if (cartRepository.existsById(cartId)) {
            cartRepository.deleteById(cartId);
        } else {
            throw new NotFoundException("Cart not found");
        }
    }

}
