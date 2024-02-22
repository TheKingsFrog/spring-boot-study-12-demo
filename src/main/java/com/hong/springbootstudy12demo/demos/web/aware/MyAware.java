package com.hong.springbootstudy12demo.demos.web.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Component;

@Component
public class MyAware implements MessageSourceAware, ApplicationContextAware {

    private ApplicationContext applicationContext;

    private MessageSource messageSource;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public void print() {
        System.out.println(applicationContext);
        System.out.println(messageSource);
    }
}
