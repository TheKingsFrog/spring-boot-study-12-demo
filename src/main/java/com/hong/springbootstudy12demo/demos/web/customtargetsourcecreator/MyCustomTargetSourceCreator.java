package com.hong.springbootstudy12demo.demos.web.customtargetsourcecreator;

import com.hong.springbootstudy12demo.demos.web.bean.MyBean;
import com.hong.springbootstudy12demo.demos.web.targetsource.MyTargetSource;
import org.springframework.aop.TargetSource;
import org.springframework.aop.framework.autoproxy.TargetSourceCreator;

public class MyCustomTargetSourceCreator implements TargetSourceCreator {
    @Override
    public TargetSource getTargetSource(Class<?> beanClass, String beanName) {
        if(beanClass.isAssignableFrom(MyBean.class)) {
            return new MyTargetSource();
        }
        return null;
    }
}
