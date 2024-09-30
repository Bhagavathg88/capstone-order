package com.spring.microservices.repository;


import com.spring.microservices.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Orders, Long> {

    public Orders findByOrderKey(UUID orderKey);

}
