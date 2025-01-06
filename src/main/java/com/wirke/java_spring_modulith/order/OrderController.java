package com.wirke.java_spring_modulith.order;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wirke.java_spring_modulith.order.dto.OrderDto;
import com.wirke.java_spring_modulith.order.dto.OrderResponseDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "order")
public class OrderController {
    
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponseDto> createOrder(@RequestBody OrderDto order) {
        return new ResponseEntity<>(orderService.createOrder(order), HttpStatus.OK);
    }
}
