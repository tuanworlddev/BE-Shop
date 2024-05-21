package com.dacs.beshop.repositories;

import com.dacs.beshop.dto.response.ProductDto;
import com.dacs.beshop.entities.Product;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAllByCategoryId(@NotNull Integer categoryId);
    Boolean existsProductById(Integer id);
}
