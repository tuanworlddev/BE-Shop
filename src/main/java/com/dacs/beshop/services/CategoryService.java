package com.dacs.beshop.services;

import com.dacs.beshop.dto.request.CategoryRequestDto;
import com.dacs.beshop.dto.response.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> getAllCategories();
    CategoryDto getCategoryById(Integer id);
    void addCategory(CategoryRequestDto categoryDto);
    void updateCategory(Integer id, CategoryRequestDto categoryDto);
    void deleteCategory(Integer id);
}
