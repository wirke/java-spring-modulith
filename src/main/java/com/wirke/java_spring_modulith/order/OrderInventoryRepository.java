package com.wirke.java_spring_modulith.order;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderInventoryRepository extends CrudRepository<OrderInventory, Long> {
    
    @Query(nativeQuery = true, value = "SELECT SUM(oi.total_qty_price) FROM order_inventory oi WHERE oi.order_id = ?1")
    long orderIdAmmount(long orderId);
}
