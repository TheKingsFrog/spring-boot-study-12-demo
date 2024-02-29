package com.hong.springbootstudy12demo.demos.web.proxy.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TraceHandler implements InvocationHandler {

    private Object target;

    public TraceHandler(Object t) {
        this.target = t;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // print method name and parameters
        System.out.println(method.getName());
        System.out.println(method.getGenericParameterTypes().toString());
        // invoke actual method
        return method.invoke(target, args);
    }
}
