package com.hong.springbootstudy12demo;

import com.hong.springbootstudy12demo.demos.web.bean.MyBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AutoProxyTest {

    @Autowired
    MyBean myBean;

    @Test
    public void test1() {
        System.out.println(myBean);
    }

}
