package com.wirke.java_spring_modulith.order;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(indexes = {
    @Index(name = "order_idx", columnList = "order_id"),
    @Index(name = "inv_idx", columnList = "inventory_id")
})
public class OrderInventory {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long orderId;
    private Long inventoryId;
    private int qty;
    private long totalQtyPrice;
}
