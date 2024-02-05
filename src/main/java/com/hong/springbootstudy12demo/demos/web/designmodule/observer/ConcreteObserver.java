package com.hong.springbootstudy12demo.demos.web.designmodule.observer;

import com.hong.springbootstudy12demo.demos.web.designmodule.generator.NumberGenerator;

public class ConcreteObserver implements Observer {
    @Override
    public void update(NumberGenerator numberGenerator) {
        System.out.println("ConcreteObserver:" + numberGenerator.getNumber());
    }
}
