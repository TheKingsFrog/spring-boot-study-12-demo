package com.hong.springbootstudy12demo;

import com.hong.springbootstudy12demo.demos.web.User;
import com.hong.springbootstudy12demo.demos.web.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

@SpringBootTest
@Slf4j
public class BeanFactoryTest {

    @Autowired
    private UserService userService;

    /**
     *  ObjectProvider是为了解决隐式注入时产生的问题而提出的概念
     */
    @Test
    public void testObjectProvider() {
        log.info("userService:{}", userService);
    }

    /**
     * ObjectFactory 使用
     */
    @Test
    public void test() {
        ObjectFactory<User> objectFactory = () -> {
            // 通过复杂逻辑生成user甚至给user生成代理
            return new Random().nextInt(100) > 50 ? new User("tom", 62) : new User("tommy", 12);
        };
        log.info("objectFactory:{}", objectFactory.getObject());
    }

}
