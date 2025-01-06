package com.wirke.java_spring_modulith.order;

import java.sql.Timestamp;
import java.time.Instant;

import com.wirke.java_spring_modulith.order.type.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "orders")
public class Order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String orderIdentifier;
    private String customerName;
    private String customerEmail;
    private Timestamp orderDate = Timestamp.from(Instant.now());
    private Status status = Status.OPEN;
}
