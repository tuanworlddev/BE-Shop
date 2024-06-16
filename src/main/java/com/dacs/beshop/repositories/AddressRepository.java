package com.dacs.beshop.repositories;

import com.dacs.beshop.entities.Address;
import com.dacs.beshop.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    List<Address> findAddressByUser(User user);
}
