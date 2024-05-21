package com.dacs.beshop.services;

import com.dacs.beshop.dto.request.ProductRequestDto;
import com.dacs.beshop.dto.response.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAllProducts();
    List<ProductDto> getProductsByCategory(Integer categoryId);
    ProductDto getProductById(int id);
    void addProduct(ProductRequestDto productDto);
    void deleteProduct(Integer id);
}
