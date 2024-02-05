package com.hong.springbootstudy12demo.demos.web.designmodule.test;

import com.hong.springbootstudy12demo.demos.web.designmodule.director.Director;
import com.hong.springbootstudy12demo.demos.web.designmodule.builder.TextBuilder;
import com.hong.springbootstudy12demo.demos.web.designmodule.generator.IncrementalNumberGenerator;
import com.hong.springbootstudy12demo.demos.web.designmodule.generator.NumberGenerator;
import com.hong.springbootstudy12demo.demos.web.designmodule.generator.RandomNumberGenerator;
import com.hong.springbootstudy12demo.demos.web.designmodule.observer.ConcreteObserver;
import com.hong.springbootstudy12demo.demos.web.designmodule.observer.DigitObserver;
import com.hong.springbootstudy12demo.demos.web.designmodule.observer.GraphObserver;
import com.hong.springbootstudy12demo.demos.web.designmodule.observer.Observer;
import org.junit.Test;

public class Main {

    @Test
    public void test() {

        TextBuilder textBuilder = new TextBuilder();

        Director director = new Director(textBuilder);

        director.construct();

        System.out.println(textBuilder.getResult());

    }

    @Test
    public void testObserver() {
        NumberGenerator numberGenerator = new RandomNumberGenerator();

        Observer observer = new DigitObserver();
        Observer observer2 = new GraphObserver();

        numberGenerator.addObserver(observer);
        numberGenerator.addObserver(observer2);

        numberGenerator.execute();

    }
    @Test
    public void testIncrementalObserver() {
        NumberGenerator numberGenerator = new IncrementalNumberGenerator(10, 50, 5);

        Observer observer = new DigitObserver();
        Observer observer2 = new GraphObserver();
        Observer observer3 = new ConcreteObserver();

        numberGenerator.addObserver(observer);
        numberGenerator.addObserver(observer2);
        numberGenerator.addObserver(observer3);

        numberGenerator.execute();

    }

}
