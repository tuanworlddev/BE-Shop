package com.dacs.beshop.services;

import com.dacs.beshop.dto.request.CategoryRequestDto;
import com.dacs.beshop.entities.Category;

import java.util.List;

public interface CategoryService {
    Category getCategoryById(Integer id);
    List<Category> getAllCategories();
    void addCategory(CategoryRequestDto categoryRequestDto);
    void updateCategory(Integer id, CategoryRequestDto categoryRequestDto);
    void deleteCategory(Integer id);
}
