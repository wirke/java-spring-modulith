package com.wirke.java_spring_modulith.order.dto;

import java.util.List;

public record OrderDto (String customerName,
                        String CustomerEmail,
                        List<InventoryRequestDto> inventoryRequestDtoList){}
