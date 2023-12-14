package com.hong.springbootstudy12demo.demos.web.test;

import com.hong.springbootstudy12demo.demos.web.User;
import com.hong.springbootstudy12demo.demos.web.test.tool.TypedStringValueToIntegerConvertor;
import com.hong.springbootstudy12demo.demos.web.test.tool.TypedStringValueToIntegerConvertor2;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.ResolvableType;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.ConverterRegistry;
import org.springframework.core.convert.support.DefaultConversionService;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class BeanUtilsTest {

    Logger logger = LoggerFactory.getLogger(BeanUtilsTest.class);


    @Test
    public void testIntroSpect() throws IntrospectionException {

        // 获取User的属性
        BeanInfo userBeanInfo = Introspector.getBeanInfo(User.class);

        // 拿到属性的描述器
        PropertyDescriptor[] propertyDescriptors = userBeanInfo.getPropertyDescriptors();

        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            logger.info("property descriptor get property => {}", propertyDescriptor.getPropertyType());
            logger.info("property descriptor get name => {}", propertyDescriptor.getName());
            logger.info("property descriptor get read method => {}", propertyDescriptor.getReadMethod());
            logger.info("property descriptor => get write method {}", propertyDescriptor.getWriteMethod());
        }

        // 获取User的属性，不拿父类Object的属性
        BeanInfo userWithoutObjectBeanInfo = Introspector.getBeanInfo(User.class, Object.class);

    }

    @Test
    public void testIntroSpect2() throws IntrospectionException, InvocationTargetException, IllegalAccessException {

        User user = new User();

        BeanInfo beanInfo = Introspector.getBeanInfo(User.class);

        PropertyDescriptor propertyDescriptor = new PropertyDescriptor("age", User.class);

        propertyDescriptor.getWriteMethod().invoke(user, 13);

        System.out.println(user.toString());

    }

    @Test
    public void testBeanWrapper() throws ClassNotFoundException {

        // beanDefinition 通过扫包获取的元数据
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClassName("com.hong.springbootstudy12demo.demos.web.User");

        MutablePropertyValues values = new MutablePropertyValues();
        values.addPropertyValue("name", "tom");
        values.addPropertyValue("age", 12);
        genericBeanDefinition.setPropertyValues(values);

        Class clazz = Class.forName(genericBeanDefinition.getBeanClassName());

        // 实例化bean做属性填充
        BeanWrapper beanWrapper = new BeanWrapperImpl(clazz);
        beanWrapper.setPropertyValues(genericBeanDefinition.getPropertyValues());
        User user = (User)beanWrapper.getWrappedInstance();

        System.out.println(user);

    }

    @Test
    public void testBatchCreate() throws ClassNotFoundException {
        // 1、通过任意形式捕获BeanDefinition
        BeanDefinitionRegistry beanDefinitionRegistry = new SimpleBeanDefinitionRegistry();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanDefinitionRegistry);
        xmlBeanDefinitionReader.loadBeanDefinitions("classpath:bean.xml");

        // 2、通过反射实例化
        for (String beanDefinitionName : beanDefinitionRegistry.getBeanDefinitionNames()) {
            BeanDefinition beanDefinition = beanDefinitionRegistry.getBeanDefinition(beanDefinitionName);
            String beanClassName = beanDefinition.getBeanClassName();
            Class clazz = Class.forName(beanClassName);

            // 3、使用BeanWrapper包裹实例，使其更方便使用反射方法
            BeanWrapper beanWrapper = new BeanWrapperImpl(clazz);

            // 4、需要自定义转化服务
            DefaultConversionService defaultConversionService = new DefaultConversionService();
            defaultConversionService.addConverter(new TypedStringValueToIntegerConvertor2());

            beanWrapper.setConversionService(defaultConversionService);
            beanWrapper.setPropertyValues(beanDefinition.getPropertyValues());
            Object bean = beanWrapper.getWrappedInstance();
            System.out.println(bean);

        }

    }

    private Map<String, User> userGroupByNameMap = new HashMap<>(8);

    @Test
    public void testResolvable() throws NoSuchFieldException {
        ResolvableType resolvableType = ResolvableType.forField(getClass().getDeclaredField("userGroupByNameMap"));
        logger.info("get generics => {}", resolvableType.getGenerics());
        logger.info("get super type => {}", resolvableType.getSuperType());
        logger.info("get type => {}", resolvableType.getType());
        logger.info("get first generic => {}", resolvableType.getGeneric(0));
        logger.info("get second generic => {}", resolvableType.getGeneric(1));
        logger.info("get as Map => {}", resolvableType.asMap());
        logger.info("get as Collection => {}", resolvableType.asCollection());
        logger.info("it's array? => {}", resolvableType.isArray());
    }




}
