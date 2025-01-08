package com.wirke.java_spring_modulith.eventpublication;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomEventPublicationServiceImp implements CustomEventPublicationService {

    private final CustomEventPublicationRepository customEventPublicationRepository;

    @Override
    public List<CustomEventPublication> getUncompletedEventPublications() {
        return customEventPublicationRepository.getCustomEventByPublicationDateNotNullAndCompletionDateIsNull();
    }

    @Override
    public List<CustomEventPublication> getCompletedEventPublications() {
        return customEventPublicationRepository.getCustomEventByPublicationDateNotNullAndCompletionDateNotNull();
    }
}
