package com.hong.springbootstudy12demo.demos.web.test;

import com.hong.springbootstudy12demo.demos.web.Dog;
import com.hong.springbootstudy12demo.demos.web.MyConfiguration;
import com.hong.springbootstudy12demo.demos.web.TeddyDog;
import com.hong.springbootstudy12demo.demos.web.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.asm.ClassReader;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.*;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.swing.text.Document;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.io.IOException;
import java.util.Arrays;


@Component
public class BeanDefinitionTest {

    Logger logger = LoggerFactory.getLogger(BeanDefinitionTest.class);

    @Test
    public void testGenericBeanDefinition() {
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
//        genericBeanDefinition.setBeanClass(User.class);
        genericBeanDefinition.setBeanClassName("com.hong.springbootstudy12demo.demos.web.User");
        genericBeanDefinition.setScope(ConfigurableBeanFactory.SCOPE_PROTOTYPE);
        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
        mutablePropertyValues.addPropertyValue("name", "hcf");
        mutablePropertyValues.addPropertyValue("age", 21);
        genericBeanDefinition.setPropertyValues(mutablePropertyValues);
    }

    @Test
    public void testChildrenBeanDefinition() {

        // 定义一个注册器
        SimpleBeanDefinitionRegistry simpleBeanDefinitionRegistry = new SimpleBeanDefinitionRegistry();

        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition();
        rootBeanDefinition.setBeanClass(Dog.class);
        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
        mutablePropertyValues.addPropertyValue("color", "milk");
        mutablePropertyValues.addPropertyValue("age", 1);
        rootBeanDefinition.setPropertyValues(mutablePropertyValues);
        simpleBeanDefinitionRegistry.registerBeanDefinition("dog", rootBeanDefinition);

        ChildBeanDefinition childBeanDefinition = new ChildBeanDefinition("dog");
        childBeanDefinition.setBeanClass(TeddyDog.class);
        mutablePropertyValues = new MutablePropertyValues();
        mutablePropertyValues.addPropertyValue("name", "hcf");
        mutablePropertyValues.addPropertyValue("age", 21);
        childBeanDefinition.setPropertyValues(mutablePropertyValues);
        simpleBeanDefinitionRegistry.registerBeanDefinition("teddyDog", childBeanDefinition);
    }

    @Test
    public void testRegistryByXml() {

        BeanDefinitionRegistry beanDefinitionRegistry = new SimpleBeanDefinitionRegistry();

        // 创建一个xml的reader
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanDefinitionRegistry);

        xmlBeanDefinitionReader.loadBeanDefinitions("classpath:bean.xml");

        logger.info("Dog ==> {}, Teddy ==> {}", beanDefinitionRegistry.getBeanDefinition("dog").getBeanClassName(), beanDefinitionRegistry.getBeanDefinition("teddy").getBeanClassName());

    }

    @Test
    public void testRegistryByAnnotation() {

        // 定义一个注册器，用来注册和管理BeanDefinition
        BeanDefinitionRegistry beanDefinitionRegistry = new SimpleBeanDefinitionRegistry();

        // 通过配置文件加载
        AnnotatedBeanDefinitionReader annotatedBeanDefinitionReader = new AnnotatedBeanDefinitionReader(beanDefinitionRegistry);
        annotatedBeanDefinitionReader.registerBean(MyConfiguration.class);

        logger.info("registry result: {}", Arrays.toString(beanDefinitionRegistry.getBeanDefinitionNames()));

    }

    @Test
    public void testClassPathBeanDefinitionScanner() {

        BeanDefinitionRegistry beanDefinitionRegistry = new SimpleBeanDefinitionRegistry();

        ClassPathBeanDefinitionScanner classPathBeanDefinitionScanner = new ClassPathBeanDefinitionScanner(beanDefinitionRegistry);
        classPathBeanDefinitionScanner.scan("com.hong.springbootstudy12demo.demos.web");
        logger.info("scan result: {}", Arrays.toString(beanDefinitionRegistry.getBeanDefinitionNames()));
    }

    @Test
    public void testAsm() throws IOException {

        // 字节码 reader 小demo 其中visitor难实现，暂无demo

        Resource resource = new ClassPathResource("com/hong/springbootstudy12demo/demos/web/User.class");

        ClassReader classReader = new ClassReader(resource.getInputStream());

        logger.info("class name => {}", classReader.getClassName());

        // 偏移量 item：常量 115行是拿第一个常量池的偏移量
        logger.info("class first item => {}", classReader.getItem(1));
        logger.info("class second item => {}", classReader.getItem(2));

        // 常量池的个数
        logger.info("item count => {}", classReader.getItemCount());

        // 常量池权限
        logger.info("item access => {}", classReader.getAccess());

    }


}
