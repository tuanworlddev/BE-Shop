package com.dacs.beshop.controllers;

import com.dacs.beshop.dto.request.CategoryRequestDto;
import com.dacs.beshop.dto.response.CategoryResponseDto;
import com.dacs.beshop.dto.response.ResponseDto;
import com.dacs.beshop.entities.Category;
import com.dacs.beshop.mapper.CategoryMapper;
import com.dacs.beshop.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<CategoryResponseDto> getAllCategories() {
        return categoryService.getAllCategories().stream().map(CategoryMapper::toCategoryResponseDto).toList();
    }

    @GetMapping("/{id}")
    public CategoryResponseDto getCategoryById(@PathVariable Integer id) {
        return CategoryMapper.toCategoryResponseDto(categoryService.getCategoryById(id));
    }

    @PostMapping
    public ResponseEntity<ResponseDto> createCategory(@RequestBody CategoryRequestDto categoryRequestDto) {
        categoryService.addCategory(categoryRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(HttpStatus.CREATED.value(), "Category created successfully"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> updateCategory(@PathVariable Integer id, @RequestBody CategoryRequestDto categoryRequestDto) {
        categoryService.updateCategory(id, categoryRequestDto);
        return ResponseEntity.ok(new ResponseDto(HttpStatus.OK.value(), "Category updated successfully"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteCategory(@PathVariable Integer id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok(new ResponseDto(HttpStatus.OK.value(), "Category deleted successfully"));
    }
}
