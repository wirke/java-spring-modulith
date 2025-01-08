package com.wirke.java_spring_modulith.eventaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Component;

import com.wirke.java_spring_modulith.eventaction.action.Action;
import com.wirke.java_spring_modulith.eventaction.action.CustomEventMarker;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Setup implements ApplicationRunner{
    
    private final EventActionRepository repository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        
        ClassPathScanningCandidateComponentProvider provider 
            = new ClassPathScanningCandidateComponentProvider(false);

        provider.addIncludeFilter(new AnnotationTypeFilter(CustomEventMarker.class));

        Set<BeanDefinition> beanDef = provider.findCandidateComponents("com.wirke.java_spring_modulith");

        Map<String, String> eventActionMap = new HashMap<>();

        for(BeanDefinition bd : beanDef){

            if(bd instanceof AnnotatedBeanDefinition){
                Map<String, Object> annotAttributeMap = ((AnnotatedBeanDefinition) bd)
                    .getMetadata()
                    .getAnnotationAttributes(CustomEventMarker.class.getCanonicalName());

                eventActionMap.put(annotAttributeMap.get("EventAction").toString(), bd.getBeanClassName()); // CustomEventMaker annotation attribute
            }
        }

        List<EventAction> eventActionList = new ArrayList<>(eventActionMap.size());

        eventActionMap.forEach((key, value) -> {
            EventAction eventAction = new EventAction();
            Action action = Action.getActionByName(key); // key is EventAction
            eventAction.setAction(action);
            eventAction.setEventCanonicalName(value);

            if(repository.getEventActionByAction(action).isEmpty()){
                eventActionList.add(eventAction);
            }
        });

        if(eventActionList.isEmpty()){
            repository.saveAll(eventActionList);
        }
    }
}
