package com.hong.springbootstudy12demo.demos.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {

    @Bean
    public User user() {
        return new User("Configuration", 23);
    }

}
