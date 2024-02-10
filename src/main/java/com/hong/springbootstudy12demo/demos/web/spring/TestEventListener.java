package com.hong.springbootstudy12demo.demos.web.spring;

import com.hong.springbootstudy12demo.demos.web.event.TestApplicationEvent;
import org.springframework.context.ApplicationListener;

public class TestEventListener implements ApplicationListener<TestApplicationEvent> {
    @Override
    public void onApplicationEvent(TestApplicationEvent event) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(event.getMessage());
    }
}
