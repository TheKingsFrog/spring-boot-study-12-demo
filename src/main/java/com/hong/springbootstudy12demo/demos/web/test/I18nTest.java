package com.hong.springbootstudy12demo.demos.web.test;

import org.junit.Test;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class I18nTest {

    @Test
    public void testMessageResource() {
        ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
        resourceBundleMessageSource.setBasename("i18n/message");
        resourceBundleMessageSource.setDefaultEncoding("UTF-8");
        resourceBundleMessageSource.setDefaultLocale(Locale.CHINA);
        String hello = resourceBundleMessageSource.getMessage("hello", new Object[]{"tom"}, Locale.getDefault());
        System.out.println(hello);
    }

}
