package com.wirke.java_spring_modulith.payment;

import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;

import com.wirke.java_spring_modulith.order.dto.OrderPaymentDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentEventService {
    
    private final PaymentRepository paymentRepository;

    //@TransactionalEventListener
    //@Async
    @ApplicationModuleListener
    void on(final OrderPaymentDto paymentDto) {

        log.info("Received order payment event: {}", paymentDto);
    }
}
