package com.hong.springbootstudy12demo.demos.web.postprocessor;

import com.hong.springbootstudy12demo.demos.web.customtargetsourcecreator.MyCustomTargetSourceCreator;
import org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator;
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

        if (bean instanceof AbstractAutoProxyCreator) {
            ((AbstractAutoProxyCreator) bean).setCustomTargetSourceCreators(new MyCustomTargetSourceCreator());
        }

        System.out.println("洪成隆beanName====>postProcessAfterInitialization");
        return bean;
    }

    @Override
    public int getOrder() {
        return -999;
    }
}
