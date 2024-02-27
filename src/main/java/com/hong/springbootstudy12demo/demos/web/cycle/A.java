package com.hong.springbootstudy12demo.demos.web.cycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class A {

    private B b;

    // 构造器注入spring无法处理，要改成setter注入并且在配置文件加上 spring.main.allow-circular-references: true
//    @Autowired
//    public A(B b) {
//        this.b = b;
//    }


    @Autowired
    public void setB(B b) {
        this.b = b;
    }
}
