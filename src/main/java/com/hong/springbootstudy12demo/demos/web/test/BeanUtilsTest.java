package com.hong.springbootstudy12demo.demos.web.test;

import com.hong.springbootstudy12demo.demos.web.User;
import com.hong.springbootstudy12demo.demos.web.test.tool.TypedStringValueToIntegerConvertor;
import com.hong.springbootstudy12demo.demos.web.test.tool.TypedStringValueToIntegerConvertor2;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
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
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
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

    @Test
    public void testUrl() throws IOException {

        Resource resource = new UrlResource("https://dldir1.qq.com/music/clntupate/QQMusic_Setup_Home.exe");
        // 获取流
        InputStream inputStream = resource.getInputStream();

        // 嫌上面麻烦的，可以采用下面这种形式
        FileUtils.copyInputStreamToFile(inputStream, new File("D://QQMusic/QQMusic_Setup_Home.exe"));

    }

    @Test
    public void testFileSystemResource() throws IOException {
        Resource resource = new FileSystemResource("D://QQMusic/QQMusic_Setup_Home.exe");
        InputStream inputStream = resource.getInputStream();
        IOUtils.copy(inputStream, new FileOutputStream("D://QQMusic2/QQMusic_Setup_Home.exe"));
    }

    @Test
    public void testClasspathResource() throws IOException {
        Resource resource = new ClassPathResource("bean.xml");
        InputStream inputStream = resource.getInputStream();
        byte[] bytes = new byte[1024];
        int len;
        while ((len = inputStream.read(bytes)) > -1) {
            logger.info(new String(bytes, 0, len));
        }

    }

    @Test
    public void testPathMatchingResourcePatternResolver() throws IOException {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource resource = resolver.getResource("https://dldir1.qq.com/music/clntupate/QQMusic_Setup_Home.exe");
        Resource xmlResource = resolver.getResource("classpath:bean.xml");
        Resource[] xmlResources = resolver.getResources("classpath*:META-INF/spring.factories");
        for (Resource xmlResource1 : xmlResources) {
            logger.info("xml resource:{}", xmlResource1);
        }
    }




}
