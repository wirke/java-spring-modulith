package com.wirke.java_spring_modulith.order.typeconverter;

import java.util.Arrays;

import com.wirke.java_spring_modulith.order.type.Status;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class StatusConverter implements AttributeConverter<Status, String> {

    @Override
    public String convertToDatabaseColumn(Status status) {
        return Arrays.stream(Status.values())
                     .filter(s -> s == status)
                     .map(Status::getCode)
                     .findFirst().orElseThrow(() -> new IllegalArgumentException("Unknown status: " + status));
    }

    @Override
    public Status convertToEntityAttribute(String code) {
        return Arrays.stream(Status.values())
                     .filter(s -> s.getCode().equalsIgnoreCase(code))
                     .findFirst().orElseThrow(() -> new IllegalArgumentException("Unknown code: " + code));
    }
}
