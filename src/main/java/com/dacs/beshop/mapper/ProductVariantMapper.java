package com.dacs.beshop.mapper;

import com.dacs.beshop.dto.response.ProductVariantResponseDto;
import com.dacs.beshop.entities.ProductVariant;

public class ProductVariantMapper {
    public static ProductVariantResponseDto toProductVariantResponseDto(ProductVariant productVariant) {
        return ProductVariantResponseDto.builder()
                .id(productVariant.getId())
                .price(productVariant.getPrice())
                .color(ColorMapper.toColorResponseDto(productVariant.getColor()))
                .size(SizeMapper.toSizeResponseDto(productVariant.getSize()))
                .quantity(productVariant.getQuantity())
                .sale(productVariant.getSale())
                .build();
    }
}
