package com.hong.springbootstudy12demo.demos.web.designmodule.generator;

import com.hong.springbootstudy12demo.demos.web.designmodule.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class NumberGenerator implements Observered {

    private List<Observer> observerList = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void deleteObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observerList.forEach(observer -> observer.update(this));
    }

    /**
     * 获取数值
     * @return int
     */
    public abstract int getNumber();

    /**
     * 生成数值
     */
    public abstract void execute();


}
