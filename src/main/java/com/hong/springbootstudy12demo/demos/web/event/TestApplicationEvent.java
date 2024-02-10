package com.hong.springbootstudy12demo.demos.web.event;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

import java.time.Clock;

public class TestApplicationEvent extends ApplicationEvent {

    private String message;

    public TestApplicationEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public TestApplicationEvent(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
