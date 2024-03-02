package com.hong.springbootstudy12demo.demos.web.postprocessor;

import com.hong.springbootstudy12demo.demos.web.cycle.A;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor, PriorityOrdered {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("洪成隆beanName====>postProcessBeforeInitialization");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // 这里可能会有人new一个新对象，或者返回一个新代理，这样就不能让spring正确处理循环依赖
//        if("a".equals(beanName)) {
//            return new A();
//        }
        // 2024年3月2日 20点45分 被我找着了吧↑ 一行一行debug出来的
        // Error creating bean with name 'a': Bean with name 'a' has been injected into other beans [b] in its raw version as part of a circular reference,
        // but has eventually been wrapped. This means that said other beans do not use the final version of the bean. This is often the result of over-eager
        // type matching - consider using 'getBeanNamesForType' with the 'allowEagerInit' flag turned off, for example.
        System.out.println("洪成隆beanName====>postProcessAfterInitialization");
        return bean;
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
