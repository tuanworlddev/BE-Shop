package com.dacs.beshop.services.impl;

import com.dacs.beshop.dto.request.ProductVariantRequestDto;
import com.dacs.beshop.entities.Product;
import com.dacs.beshop.entities.ProductVariant;
import com.dacs.beshop.exceptions.NotFoundException;
import com.dacs.beshop.repositories.ProductVariantRepository;
import com.dacs.beshop.services.ColorService;
import com.dacs.beshop.services.ProductVariantService;
import com.dacs.beshop.services.SizeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductVariantServiceImpl implements ProductVariantService {
    private final ProductVariantRepository productVariantRepository;
    private final SizeService sizeService;
    private final ColorService colorService;

    public ProductVariantServiceImpl(ProductVariantRepository productVariantRepository, SizeService sizeService, ColorService colorService) {
        this.productVariantRepository = productVariantRepository;
        this.sizeService = sizeService;
        this.colorService = colorService;
    }

    @Override
    public ProductVariant getProductVariant(Integer id) {
        return productVariantRepository.findById(id).orElseThrow(() -> new NotFoundException("Product variant not found"));
    }

    @Override
    public List<ProductVariant> getAllProductVariants() {
        return productVariantRepository.findAll();
    }

    @Override
    public void addProductVariant(ProductVariantRequestDto productVariantRequestDto, Product product) {
        ProductVariant productVariant = ProductVariant.builder()
                .product(product)
                .size(sizeService.getSizeById(productVariantRequestDto.getSizeId()))
                .color(colorService.getColorById(productVariantRequestDto.getColorId()))
                .price(productVariantRequestDto.getPrice())
                .quantity(productVariantRequestDto.getQuantity())
                .sale(productVariantRequestDto.getSale())
                .build();
        productVariantRepository.save(productVariant);
    }

    @Override
    public void deleteProductVariant(Integer id) {
        if (!productVariantRepository.existsById(id)) {
            throw new NotFoundException("Product variant not found");
        }
        productVariantRepository.deleteById(id);
    }

}
