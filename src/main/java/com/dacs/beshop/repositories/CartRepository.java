package com.dacs.beshop.repositories;

import com.dacs.beshop.entities.Cart;
import com.dacs.beshop.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Integer> {
    List<Cart> findCartsByUser(User user);
}
