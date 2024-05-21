package com.dacs.beshop.controllers;

import com.dacs.beshop.dto.request.ProductRequestDto;
import com.dacs.beshop.dto.response.ProductDto;
import com.dacs.beshop.dto.response.ResponseDto;
import com.dacs.beshop.entities.Product;
import com.dacs.beshop.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<ProductDto>> getProductById(@PathVariable Integer id) {
        return ResponseEntity.ok(productService.getProductsByCategory(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable Integer id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PostMapping
    public ResponseEntity<ResponseDto> createProduct(@RequestBody ProductRequestDto productDto) {
        productService.addProduct(productDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(HttpStatus.CREATED.value(), "Product created successfully"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteProduct(@PathVariable("id") Integer id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok(new ResponseDto(HttpStatus.OK.value(), "Product deleted successfully"));
    }


}
