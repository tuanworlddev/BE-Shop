package com.dacs.beshop.mapper;

import com.dacs.beshop.dto.request.ProductRequestDto;
import com.dacs.beshop.dto.response.ProductResponseDto;
import com.dacs.beshop.entities.Product;

public class ProductMapper {
    public static ProductResponseDto toProductDto(Product product) {
        return ProductResponseDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .category(product.getCategory().getName())
                .createdAt(product.getCreatedAt())
                .updatedAt(product.getUpdatedAt())
                .variants(product.getVariants().stream().map(ProductVariantMapper::toProductVariantResponseDto).toList())
                .images(product.getImages().stream().map(ProductImageMapper::toImageResponseDto).toList())
                .build();
    }

}
