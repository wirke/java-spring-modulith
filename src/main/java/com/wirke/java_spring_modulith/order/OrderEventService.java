package com.wirke.java_spring_modulith.order;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wirke.java_spring_modulith.order.dto.OrderPaymentDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderEventService {
    
    private final ApplicationEventPublisher eventPublisher;

    @Transactional
    public void completeOrder(final OrderPaymentDto orderPaymentDto) {

        log.info("Completingorder payment with details: {}", orderPaymentDto);
    }
}
