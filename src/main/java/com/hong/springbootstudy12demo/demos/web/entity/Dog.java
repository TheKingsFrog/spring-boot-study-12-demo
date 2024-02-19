package com.hong.springbootstudy12demo.demos.web.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Data
@Component
public class Dog {

    private String color;

    private Integer age;

    @PostConstruct
    public void init() {
        System.out.println("dog====>init");
    }

}
