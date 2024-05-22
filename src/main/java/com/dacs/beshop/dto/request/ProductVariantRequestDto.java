package com.dacs.beshop.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductVariantRequestDto {
    private Integer sizeId;
    private Integer colorId;
    private Double price;
    private Integer quantity;
    private Double sale;
}
