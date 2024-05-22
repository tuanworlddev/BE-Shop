package com.dacs.beshop.mapper;

import com.dacs.beshop.dto.response.ProductImageResponseDto;
import com.dacs.beshop.entities.ProductImage;


public class ProductImageMapper {
    public static ProductImageResponseDto toImageResponseDto(ProductImage productImage) {
        return ProductImageResponseDto.builder()
                .id(productImage.getId())
                .url(productImage.getUrl())
                .build();
    }
}
