package com.wirke.java_spring_modulith.inventory.exposed;

import java.util.List;

public interface InventoryService {
    
    InventoryDto fetchInventoryByName(String name);

    List<InventoryDto> fetchAllNames(List<String> inventoryNames);
}
