package com.dacs.beshop.repositories;

import com.dacs.beshop.entities.Category;
import com.dacs.beshop.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findProductsByCategory(Category category);
    List<Product> findProductsByNameContains(String name);
}
