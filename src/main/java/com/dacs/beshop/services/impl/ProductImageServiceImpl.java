package com.dacs.beshop.services.impl;

import com.dacs.beshop.entities.Product;
import com.dacs.beshop.entities.ProductImage;
import com.dacs.beshop.repositories.ProductImageRepository;
import com.dacs.beshop.services.ProductImageService;
import org.springframework.stereotype.Service;

@Service
public class ProductImageServiceImpl implements ProductImageService {
    private final ProductImageRepository productImageRepository;

    public ProductImageServiceImpl(ProductImageRepository productImageRepository) {
        this.productImageRepository = productImageRepository;
    }

    @Override
    public ProductImage addProductImage(String url, Product product) {
        ProductImage productImage = ProductImage.builder()
                .product(product)
                .url(url)
                .build();
        return productImageRepository.save(productImage);
    }
}
