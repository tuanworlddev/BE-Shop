package com.dacs.beshop.controllers;

import com.dacs.beshop.dto.request.ProductRequestDto;
import com.dacs.beshop.dto.response.ProductResponseDto;
import com.dacs.beshop.dto.response.ResponseDto;
import com.dacs.beshop.entities.Product;
import com.dacs.beshop.mapper.ProductMapper;
import com.dacs.beshop.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductResponseDto> getAllProducts() {
        return productService.getAllProducts().stream().map(ProductMapper::toProductDto).toList();
    }

    @GetMapping("/{id}")
    public ProductResponseDto getProductById(@PathVariable Integer id) {
        Product product = productService.getProductById(id);
        return ProductMapper.toProductDto(product);
    }

    @GetMapping("/category/{id}")
    public List<ProductResponseDto> getProductsByCategory(@PathVariable Integer id) {
        return productService.getProductsByCategory(id).stream().map(ProductMapper::toProductDto).toList();
    }

    @PostMapping
    public ResponseEntity<ResponseDto> createProduct(@RequestBody ProductRequestDto productRequestDto) {
        productService.addProduct(productRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(HttpStatus.CREATED.value(), "Product created successfully"));
    }
}
