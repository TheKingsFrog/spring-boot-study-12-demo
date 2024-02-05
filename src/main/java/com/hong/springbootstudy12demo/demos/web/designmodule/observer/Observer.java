package com.hong.springbootstudy12demo.demos.web.designmodule.observer;

import com.hong.springbootstudy12demo.demos.web.designmodule.generator.NumberGenerator;

public interface Observer {

    public abstract void update(NumberGenerator numberGenerator);

}
