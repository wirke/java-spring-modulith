package com.wirke.java_spring_modulith.eventaction.action;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum Action {
    
    PAYMENT("P"), EMAIL("E");
    
    private final String code;

    public static Action getActionByName(final String name){
        return Arrays.stream(Action.values())
            .filter(action -> action.name().equalsIgnoreCase(name))
            .findFirst().orElseThrow(null);
    }
}
