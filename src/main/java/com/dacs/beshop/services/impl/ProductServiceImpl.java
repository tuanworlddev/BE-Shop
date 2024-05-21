package com.dacs.beshop.services.impl;

import com.dacs.beshop.dto.request.ProductAttributeRequestDto;
import com.dacs.beshop.dto.request.ProductRequestDto;
import com.dacs.beshop.dto.response.ProductDto;
import com.dacs.beshop.entities.Product;
import com.dacs.beshop.exceptions.NotFoundException;
import com.dacs.beshop.mapper.CategoryMapper;
import com.dacs.beshop.mapper.ProductMapper;
import com.dacs.beshop.repositories.ProductRepository;
import com.dacs.beshop.services.CategoryService;
import com.dacs.beshop.services.ProductAttributeService;
import com.dacs.beshop.services.ProductService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductAttributeService productAttributeService;
    private final CategoryService categoryService;

    public ProductServiceImpl(ProductRepository productRepository, ProductAttributeService productAttributeService, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.productAttributeService = productAttributeService;
        this.categoryService = categoryService;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<Product> sortedProducts = products.stream()
                .sorted(Comparator.comparing(Product::getCreatedAt).reversed())
                .toList();
        return sortedProducts.stream().map(ProductMapper::toProductDto).collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> getProductsByCategory(Integer categoryId) {
        List<Product> products = productRepository.findAllByCategoryId(categoryId);
        return products.stream().map(ProductMapper::toProductDto).collect(Collectors.toList());
    }

    @Override
    public ProductDto getProductById(int id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new NotFoundException("Product not found"));
        return ProductMapper.toProductDto(product);
    }

    @Override
    public void addProduct(ProductRequestDto productDto) {
        Product product = Product.builder()
                .name(productDto.getName())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .image(productDto.getImage())
                .category(CategoryMapper.toCategory(categoryService.getCategoryById(productDto.getCategoryId())))
                .createdAt(LocalDateTime.now())
                .build();
        product = productRepository.save(product);

        for (ProductAttributeRequestDto productAttributeDto : productDto.getAttributes()) {
            productAttributeService.addProductAttribute(product, productAttributeDto);
        }

    }

    @Override
    public void deleteProduct(Integer id) {
        if (!productRepository.existsProductById(id)) {
            throw new NotFoundException("Product not found");
        }
        productRepository.deleteById(id);
    }
}
