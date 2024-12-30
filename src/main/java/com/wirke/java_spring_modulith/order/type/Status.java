package com.wirke.java_spring_modulith.order.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {
    
    OPEN("O"),
    IN_PROGRESS("IP"),
    COMPLETED("C"),
    CANCELLED("X");

    private final String code;
}
