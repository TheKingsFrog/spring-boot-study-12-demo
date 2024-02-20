package com.hong.springbootstudy12demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

@SpringBootTest
class SpringBootStudy12DemoApplicationTests {

    @Autowired
    private Environment environment;

    @Test
    void contextLoads() {
        System.out.println(environment);
    }

}
