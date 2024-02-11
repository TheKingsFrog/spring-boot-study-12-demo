package com.hong.springbootstudy12demo.demos.web.event;

import org.springframework.context.ApplicationEvent;

import java.time.Clock;

public class OrderForEmailEvent extends ApplicationEvent {



    public OrderForEmailEvent(Object source) {
        super(source);
    }

    public OrderForEmailEvent(Object source, Clock clock) {
        super(source, clock);
    }

}
