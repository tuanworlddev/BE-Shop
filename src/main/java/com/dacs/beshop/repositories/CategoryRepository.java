package com.dacs.beshop.repositories;

import com.dacs.beshop.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Boolean existsByName(String name);
}
