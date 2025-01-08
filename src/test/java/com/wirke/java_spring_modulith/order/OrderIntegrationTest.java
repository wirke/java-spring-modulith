package com.wirke.java_spring_modulith.order;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.modulith.test.Scenario;

import com.wirke.java_spring_modulith.order.dto.InventoryRequestDto;
import com.wirke.java_spring_modulith.order.dto.OrderResponseDto;
import com.wirke.java_spring_modulith.order.dto.OrderDto;
import com.wirke.java_spring_modulith.order.dto.OrderPaymentDto;

@ApplicationModuleTest
public class OrderIntegrationTest {
    
    @Autowired
    OrderService orderService;

    @Test
    void verifyModule(){
        
    }

    @Test
    void createOrder(){
        
        List<InventoryRequestDto> requestDtoList = List.of(
            new InventoryRequestDto("test product", 1),
            new InventoryRequestDto("test product 2", 1)
        );

        OrderDto orderDto = new OrderDto("greg", "greg@mail.com", requestDtoList);
        
        OrderResponseDto order = orderService.createOrder(orderDto);

        assertThat(order.message()).isEqualTo("Order currently processed");
        assertThat(order.statusCode()).isEqualTo(102);
    }

    @Test
    void publishOrderPaymentDto(Scenario scenario){
        
        scenario.publish(new OrderPaymentDto(UUID.randomUUID().toString(), 5000L))
        .andWaitForEventOfType(OrderPaymentDto.class)
        .matching(event -> event.amount() == 5000L)
        .toArriveAndVerify(ev -> System.out.println(ev.amount()));
    }
}