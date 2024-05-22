package com.dacs.beshop.repositories;

import com.dacs.beshop.entities.ProductVariant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductVariantRepository extends JpaRepository<ProductVariant, Integer> {
}
