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
        System.out.print(target);
        System.out.print("." + method.getName() + "(");
        if(args != null) {
            for (int i = 0; i < args.length; i++) {
                System.out.print(args[i]);
                if(i < args.length -1) {
                    System.out.println(",");
                }
            }
//            System.out.println(method.getGenericParameterTypes().toString());
        }
        System.out.println(")");
        // invoke actual method
        return method.invoke(target, args);
    }
}
