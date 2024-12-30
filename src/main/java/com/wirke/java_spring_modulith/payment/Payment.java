package com.wirke.java_spring_modulith.payment;

import com.wirke.java_spring_modulith.payment.type.PaymentStatus;

import java.sql.Timestamp;
import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderId;
    private long ammount;
    private Timestamp paymentDate = Timestamp.from(Instant.now());
    private PaymentStatus status = PaymentStatus.INCOMPLETE;
}
