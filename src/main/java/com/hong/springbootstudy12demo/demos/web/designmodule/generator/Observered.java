package com.hong.springbootstudy12demo.demos.web.designmodule.generator;

import com.hong.springbootstudy12demo.demos.web.designmodule.observer.Observer;

public interface Observered {

    void addObserver(Observer observer);

    void deleteObserver(Observer observer);

    void notifyObservers();

}
