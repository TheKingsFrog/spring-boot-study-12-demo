package com.hong.springbootstudy12demo;

import com.hong.springbootstudy12demo.demos.web.User;
import com.hong.springbootstudy12demo.demos.web.applicationContext.MyGenericApplicationContext;
import com.hong.springbootstudy12demo.demos.web.entity.TeddyDog;
import com.hong.springbootstudy12demo.demos.web.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.CglibSubclassingInstantiationStrategy;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.InstantiationStrategy;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

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

    /**
     * 父子工厂的访问方法
     */
    @Test
    public void test2() {

        // 创建一个核心的工厂
        DefaultListableBeanFactory parentBeanFactory = new DefaultListableBeanFactory();
        parentBeanFactory.registerSingleton("user", new User("洪成隆", 21));
        // 创建一个child工厂，独自管理各个层级的内容
        DefaultListableBeanFactory childBeanFactory = new DefaultListableBeanFactory();
        // 设置父子级关系
        childBeanFactory.setParentBeanFactory(parentBeanFactory);
        // 子工厂可以访问父工厂的bean
        System.out.println(childBeanFactory.getBean("user"));
        System.out.println(childBeanFactory.containsLocalBean("user"));
        System.out.println(parentBeanFactory.containsLocalBean("user"));
        System.out.println(childBeanFactory.containsBeanDefinition("user"));
        System.out.println(childBeanFactory.getParentBeanFactory());

    }

    /**
     * 根据策略实例化bean
     * @throws ClassNotFoundException
     */
    @Test
    public void test3() throws ClassNotFoundException {

        // 编写bean的定义
        RootBeanDefinition beanDefinition = new RootBeanDefinition();
        beanDefinition.setBeanClassName("com.hong.springbootstudy12demo.demos.web.User");
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.addPropertyValue("name", "洪成隆");
        propertyValues.addPropertyValue("age", "21");
        beanDefinition.setPropertyValues(propertyValues);
        beanDefinition.resolveBeanClass(Thread.currentThread().getContextClassLoader());

        // 创建一个beanfactory
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        defaultListableBeanFactory.registerBeanDefinition("user", beanDefinition);

        // 为啥实例化要搞策略？
        InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();
        System.out.println(instantiationStrategy.instantiate(beanDefinition, "user", defaultListableBeanFactory));

    }

    /**
     * 测试注册shutdown钩子函数
     */
    @Test
    public void test4() throws InterruptedException {

        MyGenericApplicationContext myGenericApplicationContext = new MyGenericApplicationContext();
        myGenericApplicationContext.registerShutdownHook();
        System.out.println("开始。。。");
        Thread.sleep(2000);
        System.out.println("结束。。。");

    }

    /**
     * 测试xml ApplicationContext
     */
    @Test
    public void test5() {
        GenericApplicationContext genericApplicationContext = new GenericXmlApplicationContext("classpath:bean.xml");
        TeddyDog teddy = (TeddyDog) genericApplicationContext.getBean("teddy");
        log.info("bean.xml===>{}", teddy);

    }


}
