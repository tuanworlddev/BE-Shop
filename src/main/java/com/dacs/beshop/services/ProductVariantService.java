package com.dacs.beshop.services;

import com.dacs.beshop.dto.request.ProductVariantRequestDto;
import com.dacs.beshop.entities.Product;
import com.dacs.beshop.entities.ProductVariant;

import java.util.List;

public interface ProductVariantService {
    ProductVariant getProductVariant(Integer id);
    List<ProductVariant> getAllProductVariants();
    void addProductVariant(ProductVariantRequestDto productVariantRequestDto, Product product);
    void deleteProductVariant(Integer id);
    void updateQuantityProductVariant(Integer id, Integer count);
}
