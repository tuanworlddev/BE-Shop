package com.dacs.beshop.dto.response;

import com.dacs.beshop.dto.request.ProductVariantRequestDto;
import com.dacs.beshop.entities.Product;
import com.dacs.beshop.entities.ProductVariant;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class CartResponseDto {
    private Integer id;
    private String productName;
    private String productImage;
    private ProductVariantResponseDto variant;
    private Integer quantity;
}
