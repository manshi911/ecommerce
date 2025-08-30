package com.example.ecommerce.repository;

import com.example.ecommerce.entity.Order;  // Corrected import
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    // Custom query method to find orders by user email
    List<Order> findByUserEmail(String userEmail);

}
