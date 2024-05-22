package com.dacs.beshop.mapper;

import com.dacs.beshop.dto.response.CategoryResponseDto;
import com.dacs.beshop.entities.Category;

public class CategoryMapper {
    public static CategoryResponseDto toCategoryResponseDto(Category category) {
        return CategoryResponseDto.builder()
                .id(category.getId())
                .name(category.getName())
                .image(category.getImage())
                .description(category.getDescription())
                .build();
    }
}
