package com.wirke.java_spring_modulith.payment.typeconverter;

import com.wirke.java_spring_modulith.payment.type.PaymentStatus;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Arrays;

@Converter(autoApply = true)
public class PaymentStatusConverter implements AttributeConverter<PaymentStatus, String> {

    @Override
    public String convertToDatabaseColumn(PaymentStatus status) {
        
        if(status == null) {
            throw new IllegalArgumentException("PaymentStatus is null");
        }
        return status.getCode();
    }

    @Override
    public PaymentStatus convertToEntityAttribute(String code) {
        if(code == null) {
            throw new IllegalArgumentException("PaymentStatus code is null");
        }
        return Arrays.stream(PaymentStatus.values())
                    .filter(s -> s.getCode().equalsIgnoreCase(code))
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
    }
    
}
