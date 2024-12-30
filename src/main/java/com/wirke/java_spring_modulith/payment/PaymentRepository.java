package com.wirke.java_spring_modulith.payment;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface PaymentRepository extends CrudRepository<Payment, Long> {
    
    Optional<Payment> getPaymentByOrderId(String orderId);
}
