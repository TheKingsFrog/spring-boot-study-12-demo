package com.hong.springbootstudy12demo.demos.web.test.tool;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.env.*;

import java.util.Properties;

public class ToolTest {

    private static final Logger logger = LoggerFactory.getLogger(ToolTest.class);

    @Test
    public void testMoreEnvProperties() {
        ApplicationContext applicationContext = new GenericApplicationContext();
        Environment environment = applicationContext.getEnvironment();
        boolean javaHome = environment.containsProperty("JAVA_HOME");
        logger.info("Does my environment the 'JAVA_HOME' property ? {} ", javaHome);
        logger.info("the 'JAVA_HOME' is: {} ", environment.getProperty("JAVA_HOME"));
    }

    @Test
    public void testStandardEnv() {

        // 定义一个标准环境
        StandardEnvironment standardEnvironment = new StandardEnvironment();

        // 定义一个properties
        Properties properties = new Properties();
        properties.setProperty("HCLLUCK7", "Hzuck7");
        PropertySource propertySource = new PropertiesPropertySource("HCL", properties);
        MutablePropertySources propertySources = standardEnvironment.getPropertySources();

        // 添加一个properties
        propertySources.addLast(propertySource);

        standardEnvironment.getProperty("JAVA_HOME");
        standardEnvironment.getProperty("HCLLUCK7");
    }

}
