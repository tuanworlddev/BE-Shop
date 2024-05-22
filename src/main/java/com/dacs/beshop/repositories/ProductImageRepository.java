package com.dacs.beshop.repositories;

import com.dacs.beshop.entities.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductImageRepository extends JpaRepository<ProductImage, Integer> {
}
