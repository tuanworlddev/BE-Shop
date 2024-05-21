package com.dacs.beshop.services;

import com.dacs.beshop.dto.request.ProductAttributeRequestDto;
import com.dacs.beshop.entities.Product;


public interface ProductAttributeService {
    void addProductAttribute(Product product, ProductAttributeRequestDto productAttributeDto);
}
