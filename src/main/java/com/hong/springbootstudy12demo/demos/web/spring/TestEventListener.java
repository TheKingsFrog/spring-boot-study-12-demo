package com.hong.springbootstudy12demo.demos.web.spring;

import lombok.extern.log4j.Log4j;
import org.springframework.context.ApplicationListener;

public class TestEventListener implements ApplicationListener<TestApplicationEvent> {
    @Override
    public void onApplicationEvent(TestApplicationEvent event) {
        System.out.println(event.getMessage());
    }
}
