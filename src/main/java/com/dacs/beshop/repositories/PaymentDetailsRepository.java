package com.dacs.beshop.repositories;

import com.dacs.beshop.entities.PaymentDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentDetailsRepository extends JpaRepository<PaymentDetails, Integer> {
}
