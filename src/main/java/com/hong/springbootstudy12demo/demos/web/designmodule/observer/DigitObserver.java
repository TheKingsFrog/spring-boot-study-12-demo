package com.hong.springbootstudy12demo.demos.web.designmodule.observer;

import com.hong.springbootstudy12demo.demos.web.designmodule.generator.NumberGenerator;

public class DigitObserver implements Observer {
    @Override
    public void update(NumberGenerator numberGenerator) {
        System.out.println("DigitObserver:" + numberGenerator.getNumber());
        try {
            Thread.sleep(100);
        } catch (InterruptedException interruptedException) {

        }
    }
}
