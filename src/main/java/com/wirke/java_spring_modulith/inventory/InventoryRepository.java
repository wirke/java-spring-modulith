package com.wirke.java_spring_modulith.inventory;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface InventoryRepository extends CrudRepository<Inventory, Long> {
    
    Optional<Inventory> findByName(String name);
    List<Inventory> findByNameIn(List<String> names);
}
