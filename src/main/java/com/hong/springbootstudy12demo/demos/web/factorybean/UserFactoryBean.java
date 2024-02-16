package com.hong.springbootstudy12demo.demos.web.factorybean;

import com.hong.springbootstudy12demo.demos.web.User;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component("user")
public class UserFactoryBean implements FactoryBean<User> {
    @Override
    public User getObject() throws Exception {
        // 源码里这个过程可能很复杂，帮助我们完成复杂对象的创建
        return new User("洪成隆", 21);
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
