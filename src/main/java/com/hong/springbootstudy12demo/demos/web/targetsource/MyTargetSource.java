package com.hong.springbootstudy12demo.demos.web.targetsource;

import com.hong.springbootstudy12demo.demos.web.bean.MyBean;
import org.springframework.aop.TargetSource;
import org.springframework.transaction.annotation.Transactional;

public class MyTargetSource implements TargetSource {
    @Override
    public Class<?> getTargetClass() {
        return MyBean.class;
    }

    @Override
    public boolean isStatic() {
        return false;
    }

    @Override
    public Object getTarget() throws Exception {
        MyBean myBean = new MyBean();
        myBean.setTitle("---->这里是MyTargetSource创建的");
        return myBean;
    }

    @Override
    @Transactional
    public void releaseTarget(Object target) throws Exception {

    }
}
