package com.hong.springbootstudy12demo.demos.web.designmodule.observer;

import com.hong.springbootstudy12demo.demos.web.designmodule.generator.NumberGenerator;

public class GraphObserver implements Observer{
    @Override
    public void update(NumberGenerator numberGenerator) {
        System.out.println("GraphObserver:");
        int number = numberGenerator.getNumber();
        for (int i = 0; i < number; i++) {
            System.out.println("*");
        }
        System.out.println("");
        try {
            Thread.sleep(100);
        } catch (InterruptedException interruptedException) {

        }
    }
}
