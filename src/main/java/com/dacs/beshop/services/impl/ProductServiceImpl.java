package com.dacs.beshop.services.impl;

import com.dacs.beshop.dto.request.ProductRequestDto;
import com.dacs.beshop.dto.request.ProductVariantRequestDto;
import com.dacs.beshop.entities.Category;
import com.dacs.beshop.entities.Product;
import com.dacs.beshop.exceptions.NotFoundException;
import com.dacs.beshop.repositories.ProductRepository;
import com.dacs.beshop.services.CategoryService;
import com.dacs.beshop.services.ProductImageService;
import com.dacs.beshop.services.ProductService;
import com.dacs.beshop.services.ProductVariantService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductVariantService productVariantService;
    private final ProductImageService productImageService;
    private final CategoryService categoryService;

    public ProductServiceImpl(ProductRepository productRepository, ProductVariantService productVariantService, ProductImageService productImageService, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.productVariantService = productVariantService;
        this.productImageService = productImageService;
        this.categoryService = categoryService;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<Product> productsToDelete = products.stream()
                .filter(product -> product.getVariants().isEmpty())
                .toList();
        if (!productsToDelete.isEmpty()) {
            productRepository.deleteAll(productsToDelete);
        }
        return products.stream()
                .filter(product -> !product.getVariants().isEmpty())
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> getProductByQuery(String query) {
        return productRepository.findProductsByNameContains(query);
    }

    @Override
    public List<Product> getProductsByCategory(Integer categoryId) {
        Category category = categoryService.getCategoryById(categoryId);
        return productRepository.findProductsByCategory(category);
    }

    @Override
    public Product getProductById(Integer id) {
        return productRepository.findById(id).orElseThrow(() -> new NotFoundException("Product not found"));
    }

    @Override
    @Transactional
    public void addProduct(ProductRequestDto productRequestDto) {
        Product product = Product.builder()
                .name(productRequestDto.getName())
                .description(productRequestDto.getDescription())
                .category(categoryService.getCategoryById(productRequestDto.getCategoryId()))
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        final Product savedProduct = productRepository.save(product);

        productRequestDto.getVariants().forEach(variantDto ->
                productVariantService.addProductVariant(variantDto, savedProduct)
        );

        productRequestDto.getImages().forEach(imageUrl ->
                productImageService.addProductImage(imageUrl, savedProduct)
        );
    }
}
