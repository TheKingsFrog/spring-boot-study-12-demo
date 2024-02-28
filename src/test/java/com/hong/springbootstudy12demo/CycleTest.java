package com.hong.springbootstudy12demo;

import com.hong.springbootstudy12demo.demos.web.cycle.A;
import com.hong.springbootstudy12demo.demos.web.cycle.B;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CycleTest {

    @Autowired
    private A a;

    @Autowired
    private B b;

    /**
     * 循环依赖测试
     */
    @Test
    public void test() {
        System.out.println(a);
        System.out.println(b);
        System.out.println("hello world!");
    }

}
