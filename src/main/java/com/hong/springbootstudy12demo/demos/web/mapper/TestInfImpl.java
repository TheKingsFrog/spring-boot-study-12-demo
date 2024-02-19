package com.hong.springbootstudy12demo.demos.web.mapper;

import com.hong.springbootstudy12demo.demos.web.entity.Dog;

public class TestInfImpl implements TestInterface<Dog> {
    @Override
    public void test(Dog dog) {
        System.out.println("test dog ...");
    }


}
