package com.dacs.beshop.services;

import com.dacs.beshop.dto.request.ProductRequestDto;
import com.dacs.beshop.entities.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(Integer categoryId);
    Product getProductById(Integer id);
    void addProduct(ProductRequestDto productRequestDto);

}
