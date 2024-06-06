package com.dacs.beshop.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductVariantResponseDto {
    private Integer id;
    private SizeResponseDto size;
    private ColorResponseDto color;
    private Integer quantity;
    private Double price;
    private Double sale;
}
