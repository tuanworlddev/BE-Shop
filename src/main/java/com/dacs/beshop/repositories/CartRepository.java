package com.dacs.beshop.repositories;

import com.dacs.beshop.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {
}
