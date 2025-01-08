package com.wirke.java_spring_modulith.eventpublication;

import java.util.List;

public interface CustomEventPublicationService {
    
    List<CustomEventPublication> getUncompletedEventPublications();
    List<CustomEventPublication> getCompletedEventPublications();
}
