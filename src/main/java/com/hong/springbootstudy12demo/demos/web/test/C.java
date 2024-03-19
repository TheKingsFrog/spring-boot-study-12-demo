package com.hong.springbootstudy12demo.demos.web.test;

import static com.hong.springbootstudy12demo.demos.web.test.A.x;

public class C implements A {


    public void print() {
        System.out.println(x);
    }

    public static void main(String[] args) {
        new C().print();
    }

}
