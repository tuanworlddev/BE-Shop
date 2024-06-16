package com.dacs.beshop.repositories;

import com.dacs.beshop.entities.OrderDetails;
import com.dacs.beshop.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {
    List<OrderDetails> findOrderDetailsByUser(User user);
}
