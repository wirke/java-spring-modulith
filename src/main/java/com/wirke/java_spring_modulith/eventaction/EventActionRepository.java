package com.wirke.java_spring_modulith.eventaction;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wirke.java_spring_modulith.eventaction.action.Action;

@Repository
public interface EventActionRepository extends CrudRepository<EventAction, Long> {
    
    Optional<EventAction> getEventActionByAction(Action action);
}
