package com.wirke.java_spring_modulith.inventory;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface InventoryRepository extends JpaRepository<Inventory, Long> {
    
    Optional<Inventory> getInventoryName(String name);
    List<Inventory> getInventoryByNameIn(List<String> names);
}
