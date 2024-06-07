package com.dacs.beshop.dto.response;

import com.dacs.beshop.entities.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class CartResponseDto {
    private Integer id;
    private Double total;
    private List<CartItemResponseDto> cartItems;
}
