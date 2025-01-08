package com.wirke.java_spring_modulith.eventaction.action;

import jakarta.persistence.AttributeConverter;

import java.util.Arrays;

public class ActionConverter implements AttributeConverter<Action, String> {
    
    @Override
    public String convertToDatabaseColumn(Action action) {
        
        if(action == null) throw new RuntimeException("action is null");
        return action.getCode();
    }

    @Override
    public Action convertToEntityAttribute(String code) {
        
        if(code == null) throw new RuntimeException("action is null");
        return Arrays.stream(Action.values())
        .filter(action -> action.getCode().equalsIgnoreCase(code))
        .findFirst().orElseThrow(() -> new RuntimeException("action not found"));
    }
}
