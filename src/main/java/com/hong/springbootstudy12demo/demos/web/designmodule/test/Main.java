package com.hong.springbootstudy12demo.demos.web.designmodule.test;

import com.hong.springbootstudy12demo.demos.web.designmodule.director.Director;
import com.hong.springbootstudy12demo.demos.web.designmodule.builder.TextBuilder;
import org.junit.Test;

public class Main {

    @Test
    public void test() {

        TextBuilder textBuilder = new TextBuilder();

        Director director = new Director(textBuilder);

        director.construct();

        System.out.println(textBuilder.getResult());

    }

}
