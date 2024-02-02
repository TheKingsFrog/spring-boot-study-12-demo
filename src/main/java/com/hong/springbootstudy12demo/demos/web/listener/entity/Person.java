package com.hong.springbootstudy12demo.demos.web.listener.entity;

import lombok.Data;

@Data
public class Person {

    private String name;

    public Person(String name) {
        this.name = name;
    }



}
