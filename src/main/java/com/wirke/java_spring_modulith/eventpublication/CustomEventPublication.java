package com.wirke.java_spring_modulith.eventpublication;

import java.security.Timestamp;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "event_publication")
public class CustomEventPublication {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String listenerId;
    private String eventType;
    private String serialized;
    private Timestamp publicationDate;
    private Timestamp completionDate;
}
