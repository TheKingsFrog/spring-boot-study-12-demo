package com.hong.springbootstudy12demo;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Log4j2
@SpringBootTest
public class FactoryBeanTest {

    @Autowired
    private BeanFactory beanFactory;

    /**
     * 用bean工厂获取UserFactoryBean
     */
    @Test
    public void test4() {
        // 拿到User
        log.info("user --> {}", beanFactory.getBean("user"));
        // 拿到UserFactoryBean 需要在原先user前面加上&符号
        log.info("user --> {}", beanFactory.getBean("&user"));
    }

}
