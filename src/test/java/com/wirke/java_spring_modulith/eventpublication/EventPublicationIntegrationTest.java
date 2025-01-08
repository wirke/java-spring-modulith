package com.wirke.java_spring_modulith.eventpublication;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.modulith.test.ApplicationModuleTest;

@ApplicationModuleTest
public class EventPublicationIntegrationTest {
    
    @Autowired
    CustomEventPublicationService service;

    @Test
    void getUncompletedEventPublicationTest(){
        List<CustomEventPublication> uncompleted = service.getUncompletedEventPublications();

        uncompleted.forEach(ev -> {
            assertThat(ev).isInstanceOf(CustomEventPublication.class);
            assertThat(ev.getCompletionDate()).isNull();
        });
    }

    @Test
    void getCompletedEventPublicationTest(){
        List<CustomEventPublication> completed = service.getCompletedEventPublications();

        completed.forEach(ev -> {
            assertThat(ev).isInstanceOf(CustomEventPublication.class);
            assertThat(ev.getCompletionDate()).isNotNull();
        });
    }
}
