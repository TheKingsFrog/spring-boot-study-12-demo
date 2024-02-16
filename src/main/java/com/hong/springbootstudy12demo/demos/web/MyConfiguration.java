package com.hong.springbootstudy12demo.demos.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 跟UserFactoryBean冲突了 先注释
//@Configuration
public class MyConfiguration {

    @Bean
    public User user() {
        return new User("Configuration", 23);
    }

}
