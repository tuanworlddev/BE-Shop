package com.dacs.beshop.mapper;

import com.dacs.beshop.dto.response.ProductAttributeDto;
import com.dacs.beshop.dto.response.ProductDto;
import com.dacs.beshop.entities.Product;

import java.util.List;

public class ProductMapper {
    public static ProductDto toProductDto(Product product) {
        ProductDto productDto = ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .sale(product.getSale())
                .description(product.getDescription())
                .image(product.getImage())
                .category(product.getCategory().getName())
                .createdAt(product.getCreatedAt())
                .updatedAt(product.getUpdatedAt())
                .build();

        List<ProductAttributeDto> attributeDtos = product.getAttributes().stream()
                .map(ProductAttributeMapper::toProductAttributeDto)
                .toList();
        productDto.setAttributes(attributeDtos);

        return productDto;
    }
}
