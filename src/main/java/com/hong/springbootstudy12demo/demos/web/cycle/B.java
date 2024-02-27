package com.hong.springbootstudy12demo.demos.web.cycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("hcl")
public class B {

    private A a;

    // 构造器注入spring无法处理，要改成setter注入并且在配置文件加上 spring.main.allow-circular-references: true
//    @Autowired
//    public B(A a) {
//        this.a = a;
//    }


    @Autowired
    public void setA(A a) {
        this.a = a;
    }

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        a.setB(b);
        b.setA(a);
    }

}
