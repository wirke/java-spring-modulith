package com.wirke.java_spring_modulith.inventory;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wirke.java_spring_modulith.inventory.exposed.InventoryDto;
import com.wirke.java_spring_modulith.inventory.exposed.InventoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
class InventoryServiceImp implements InventoryService{

    private final InventoryRepository inventoryRepository;

    @Override
    public InventoryDto fetchInventoryByName(String name) {
        return inventoryRepository.findByName(name)
        .map(InventoryUtil::mapInventoryDto)
        .orElseThrow(() -> new IllegalArgumentException("Inventory not found by name: " + name));
    }

    @Override
    public List<InventoryDto> fetchAllNames(List<String> inventoryNames) {
        return inventoryRepository.findByNameIn(inventoryNames)
        .stream()
        .map(InventoryUtil::mapInventoryDto)
        .toList();
    }
}