package com.dacs.beshop.services;

import com.dacs.beshop.entities.Product;
import com.dacs.beshop.entities.ProductImage;

public interface ProductImageService {
    ProductImage addProductImage(String url, Product product);
}
