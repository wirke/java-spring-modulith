package com.wirke.java_spring_modulith.order.dto;

import org.jmolecules.event.types.DomainEvent;

import com.wirke.java_spring_modulith.eventaction.action.Action;
import com.wirke.java_spring_modulith.eventaction.action.CustomEventMarker;

@CustomEventMarker(eventAction = Action.PAYMENT)
public record OrderPaymentDto (String orderId, long amount) implements DomainEvent {}
