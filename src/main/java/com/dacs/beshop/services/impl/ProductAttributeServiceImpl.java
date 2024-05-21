package com.dacs.beshop.services.impl;

import com.dacs.beshop.dto.request.ProductAttributeRequestDto;
import com.dacs.beshop.entities.Product;
import com.dacs.beshop.entities.ProductAttribute;
import com.dacs.beshop.mapper.ProductAttributeMapper;
import com.dacs.beshop.repositories.ProductAttributeRepository;
import com.dacs.beshop.services.ProductAttributeService;
import org.springframework.stereotype.Service;

@Service
public class ProductAttributeServiceImpl implements ProductAttributeService {
    private final ProductAttributeRepository productAttributeRepository;

    public ProductAttributeServiceImpl(ProductAttributeRepository productAttributeRepository) {
        this.productAttributeRepository = productAttributeRepository;
    }

    @Override
    public void addProductAttribute(Product product, ProductAttributeRequestDto productAttributeDto) {
        ProductAttribute productAttribute = ProductAttributeMapper.toProductAttribute(productAttributeDto);
        productAttribute.setProduct(product);
        productAttributeRepository.save(productAttribute);
    }
}
