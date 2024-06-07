package com.dacs.beshop.services.impl;

import com.dacs.beshop.dto.request.CartItemRequestDto;
import com.dacs.beshop.entities.Cart;
import com.dacs.beshop.entities.CartItem;
import com.dacs.beshop.entities.Product;
import com.dacs.beshop.entities.ProductVariant;
import com.dacs.beshop.repositories.CartItemRepository;
import com.dacs.beshop.services.CartItemService;
import com.dacs.beshop.services.ProductVariantService;
import org.springframework.stereotype.Service;

@Service
public class CartItemServiceImpl implements CartItemService {
    private final CartItemRepository cartItemRepository;
    private final ProductVariantService productVariantService;

    public CartItemServiceImpl(CartItemRepository cartItemRepository, ProductVariantService productVariantService) {
        this.cartItemRepository = cartItemRepository;
        this.productVariantService = productVariantService;
    }

    @Override
    public void addCartItem(Cart cart, CartItemRequestDto cartItemRequestDto) {
        ProductVariant productVariant = productVariantService.getProductVariant(cartItemRequestDto.getVariantId());

        CartItem cartItem = CartItem.builder()
                .cart(cart)
                .productVariant(productVariant)
                .quantity(cartItemRequestDto.getQuantity())
                .price(cartItemRequestDto.getPrice())
                .build();
        cartItemRepository.save(cartItem);
    }

}
