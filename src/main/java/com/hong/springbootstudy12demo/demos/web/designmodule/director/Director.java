package com.hong.springbootstudy12demo.demos.web.designmodule.director;

import com.hong.springbootstudy12demo.demos.web.designmodule.builder.Builder;

public class Director {

    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void construct() {

        builder
                .makeTitle("Greeting")
                .makeItems(new String[] {"欢迎光临", "MINISO", "请随意挑选"})
                .makeString("晚上")
                .close();

    }

}
