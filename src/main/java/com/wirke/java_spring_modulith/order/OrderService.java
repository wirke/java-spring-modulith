package com.wirke.java_spring_modulith.order;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.wirke.java_spring_modulith.inventory.exposed.InventoryDto;
import com.wirke.java_spring_modulith.inventory.exposed.InventoryService;
import com.wirke.java_spring_modulith.order.dto.InventoryRequestDto;
import com.wirke.java_spring_modulith.order.dto.OrderDto;
import com.wirke.java_spring_modulith.order.dto.OrderResponseDto;
import com.wirke.java_spring_modulith.order.type.Status;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

    private final InventoryService inventoryService;
    private final OrderRepository orderRepository;
    private final OrderInventoryRepository orderInventoryRepository;

    public OrderResponseDto createOrder(OrderDto orderDto) {
        
        List<String> inventoryNames = orderDto.InventoryRequestDtoList()
            .stream()
            .map(InventoryRequestDto::inventoryName)
            .toList();

        List<InventoryDto> inventories = inventoryService.fetchAllNames(inventoryNames);
        Order order = buildAndPersistOrder(orderDto);
        final AtomicLong amount = new AtomicLong();
        log.info("Order created: {}", order);
        buildAndPersistOrderInventory(orderDto, inventories, order.getId(), amount);

        return new OrderResponseDto("Order currently processed", 102);
    }

    private void buildAndPersistOrderInventory(OrderDto orderDto, List<InventoryDto> inventories, Long OrderId, AtomicLong amount) {
        
        List<OrderInventory> orderInventories = new ArrayList<>(inventories.size());

        inventories.forEach(inventoryDto -> {
            OrderInventory orderInventory = new OrderInventory();
            InventoryRequestDto inventoryRequestDto = getInventoryRequestDtoByName(inventoryDto.name(), orderDto.InventoryRequestDtoList());
            orderInventory.setInventoryId(inventoryDto.id());
            orderInventory.setQty(inventoryRequestDto.qty());
            long totalPrice = inventoryDto.price() * inventoryRequestDto.qty();
            orderInventory.setTotalQtyPrice(totalPrice);
            orderInventories.add(orderInventory);
            amount.addAndGet(totalPrice);
        });

        log.info("Order Inventory created: {}", orderInventories);
        orderInventoryRepository.saveAll(orderInventories);
    }

    private static InventoryRequestDto getInventoryRequestDtoByName(String inventoryName,
                                                                    List<InventoryRequestDto> inventoryRequestDtoList){
        return inventoryRequestDtoList.stream()
        .filter(inv -> inv.inventoryName().equals(inventoryName))
        .findFirst().orElse(null);
    }

    private Order buildAndPersistOrder(OrderDto orderDto){

        Order order = new Order();
        order.setOrderIdentifier(UUID.randomUUID().toString());
        order.setCustomerName(orderDto.customerName());
        order.setCustomerEmail(orderDto.CustomerEmail());
        order.setStatus(Status.COMPLETED);

        return orderRepository.save(order);
    }
}
