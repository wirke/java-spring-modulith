package com.wirke.java_spring_modulith.order;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
    
    Optional<Order> getOrderIdentifier(String orderIdentifier);
}
