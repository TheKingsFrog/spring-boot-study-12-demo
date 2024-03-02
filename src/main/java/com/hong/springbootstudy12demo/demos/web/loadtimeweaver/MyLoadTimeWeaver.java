package com.hong.springbootstudy12demo.demos.web.loadtimeweaver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.weaving.LoadTimeWeaverAware;
import org.springframework.instrument.classloading.LoadTimeWeaver;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

//@Component
public class MyLoadTimeWeaver {

//    LoadTimeWeaver loadTimeWeaver;
//
//    @Override
//    public void setLoadTimeWeaver(LoadTimeWeaver loadTimeWeaver) {
//        this.loadTimeWeaver = loadTimeWeaver;
//    }
//
//    @PostConstruct
//    public void init() {
//        loadTimeWeaver.addTransformer(null);
//    }

}
