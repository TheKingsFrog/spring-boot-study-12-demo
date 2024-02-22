package com.hong.springbootstudy12demo;

import com.hong.springbootstudy12demo.demos.web.aware.MyAware;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AwareTest {

    @Autowired
    private MyAware myAware;

    @Test
    public void test() {
        myAware.print();
    }

}

