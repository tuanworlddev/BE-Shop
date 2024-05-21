package com.dacs.beshop.mapper;

import com.dacs.beshop.dto.request.ProductAttributeRequestDto;
import com.dacs.beshop.dto.response.ProductAttributeDto;
import com.dacs.beshop.entities.ProductAttribute;

public class ProductAttributeMapper {
    public static ProductAttributeDto toProductAttributeDto(ProductAttribute productAttribute) {
        return ProductAttributeDto.builder()
                .type(productAttribute.getType())
                .value(productAttribute.getValue())
                .build();
    }

    public static ProductAttribute toProductAttribute(ProductAttributeRequestDto productAttributeDto) {
        return ProductAttribute.builder()
                .type(productAttributeDto.getType())
                .value(productAttributeDto.getValue())
                .build();
    }
}
