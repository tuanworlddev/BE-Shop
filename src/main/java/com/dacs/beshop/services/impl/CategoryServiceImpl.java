package com.dacs.beshop.services.impl;

import com.dacs.beshop.dto.request.CategoryRequestDto;
import com.dacs.beshop.entities.Category;
import com.dacs.beshop.exceptions.AlreadyExistsException;
import com.dacs.beshop.exceptions.NotFoundException;
import com.dacs.beshop.repositories.CategoryRepository;
import com.dacs.beshop.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category getCategoryById(Integer id) {
        return categoryRepository.findById(id).orElseThrow(() -> new NotFoundException("Category not found"));
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void addCategory(CategoryRequestDto categoryRequestDto) {
        if (categoryRepository.existsByName(categoryRequestDto.getName())) {
            throw new AlreadyExistsException("Category already exists");
        }
        Category category = Category.builder()
                .name(categoryRequestDto.getName())
                .image(categoryRequestDto.getImage())
                .description(categoryRequestDto.getDescription())
                .build();
        categoryRepository.save(category);
    }

    @Override
    public void updateCategory(Integer id, CategoryRequestDto categoryRequestDto) {
        Category category = getCategoryById(id);
        category.setName(categoryRequestDto.getName());
        category.setImage(categoryRequestDto.getImage());
        category.setDescription(categoryRequestDto.getDescription());
        categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Integer id) {
        Category category = getCategoryById(id);
        categoryRepository.delete(category);
    }
}
