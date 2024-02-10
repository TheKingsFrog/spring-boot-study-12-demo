package com.hong.springbootstudy12demo.demos.web.spring;

import com.hong.springbootstudy12demo.demos.web.event.TestApplicationEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class TestPublishEvent {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publish(String message) {

        applicationEventPublisher.publishEvent(new TestApplicationEvent(message));

    }


}
