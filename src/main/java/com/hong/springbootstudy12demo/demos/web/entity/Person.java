package com.hong.springbootstudy12demo.demos.web.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Person implements Serializable {

    private String name;

    private Integer age;

}
