package com.hong.springbootstudy12demo.demos.web.listener.entity;

import lombok.Data;

@Data
public class PersonEvent {

    private Person person;

    private String addOrUpdate;

    public PersonEvent(Person person, String addOrUpdate) {
        this.person = person;
        this.addOrUpdate = addOrUpdate;
    }



}
