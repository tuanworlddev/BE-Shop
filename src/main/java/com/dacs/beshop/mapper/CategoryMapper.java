package com.dacs.beshop.mapper;

import com.dacs.beshop.dto.response.CategoryDto;
import com.dacs.beshop.entities.Category;

public class CategoryMapper {
    public static CategoryDto toCategoryDto(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .image(category.getImage())
                .build();
    }

    public static Category toCategory(CategoryDto categoryDto) {
        return Category.builder()
                .id(categoryDto.getId())
                .name(categoryDto.getName())
                .image(categoryDto.getImage())
                .build();
    }

}
