package com.wirke.java_spring_modulith.inventory;

import com.wirke.java_spring_modulith.inventory.exposed.InventoryDto;

import lombok.experimental.UtilityClass;

@UtilityClass
public class InventoryUtil {
    
    public InventoryDto mapInventoryDto(Inventory inventory) {
        return new InventoryDto(inventory.getId(), 
                                inventory.getName(), 
                                inventory.getDescription(), 
                                inventory.getPrice());
    }
}