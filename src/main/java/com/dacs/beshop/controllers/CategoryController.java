package com.dacs.beshop.controllers;

import com.dacs.beshop.dto.request.CategoryRequestDto;
import com.dacs.beshop.dto.response.CategoryDto;
import com.dacs.beshop.dto.response.ResponseDto;
import com.dacs.beshop.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpMethod;
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
    public List<CategoryDto> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public CategoryDto getCategory(@PathVariable Integer id) {
        return categoryService.getCategoryById(id);
    }

    @PostMapping
    public ResponseEntity<ResponseDto> createCategory(@Valid @RequestBody CategoryRequestDto categoryDto) {
        categoryService.addCategory(categoryDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(HttpStatus.CREATED.value(), "Category created successfully"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> updateCategory(@PathVariable("id") Integer id, @Valid @RequestBody CategoryRequestDto categoryDto) {
        categoryService.updateCategory(id, categoryDto);
        return ResponseEntity.ok(new ResponseDto(HttpStatus.OK.value(), "Category updated successfully"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteCategory(@PathVariable("id") Integer id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok(new ResponseDto(HttpStatus.OK.value(), "Category deleted successfully"));
    }
}
