package com.dacs.beshop.services.impl;

import com.dacs.beshop.dto.request.CategoryRequestDto;
import com.dacs.beshop.dto.response.CategoryDto;
import com.dacs.beshop.entities.Category;
import com.dacs.beshop.exceptions.AlreadyExistsException;
import com.dacs.beshop.exceptions.NotFoundException;
import com.dacs.beshop.mapper.CategoryMapper;
import com.dacs.beshop.repositories.CategoryRepository;
import com.dacs.beshop.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    private Category findCategoryById(Integer id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Category not found"));
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(CategoryMapper::toCategoryDto).collect(Collectors.toList());
    }

    @Override
    public CategoryDto getCategoryById(Integer id) {
        Category category = findCategoryById(id);
        return CategoryMapper.toCategoryDto(category);
    }

    @Override
    public void addCategory(CategoryRequestDto categoryDto) {
        if (categoryRepository.existsByName(categoryDto.getName())) {
            throw new AlreadyExistsException("Category with name " + categoryDto.getName() + " already exists");
        }
        Category category = Category.builder()
                .name(categoryDto.getName())
                .description(categoryDto.getDescription())
                .image(categoryDto.getImage())
                .build();
        categoryRepository.save(category);
    }

    @Override
    public void updateCategory(Integer id, CategoryRequestDto categoryDto) {
        Category category = findCategoryById(id);
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());
        category.setImage(categoryDto.getImage());
        categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Integer id) {
        Category category = findCategoryById(id);
        categoryRepository.delete(category);
    }
}
