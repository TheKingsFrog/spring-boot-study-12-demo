package com.hong.springbootstudy12demo.demos.web.proxy.util;

import com.hong.springbootstudy12demo.demos.web.proxy.Star;
import com.hong.springbootstudy12demo.demos.web.proxy.SuperStar;
import com.hong.springbootstudy12demo.demos.web.proxy.handler.TraceHandler;
import com.hong.springbootstudy12demo.demos.web.proxy.service.UserService;
import com.hong.springbootstudy12demo.demos.web.proxy.service.impl.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Stack;

public class ProxyUtil {

    public static Star createProxy(SuperStar superStar) {


        /**
         *         newProxyInstance(ClassLoader loader,Class<?>[] interfaces,InvocationHandler h)
         *         参数1：用于指定一个类加载器
         *         参数2：指定生成的代理长什么样子，也就是有哪些方法
         *         参数3：用来指定生成的代理对象要干什么事情
         */
        Star proxy = (Star) Proxy.newProxyInstance(ProxyUtil.class.getClassLoader(), new Class[]{Star.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 代理对象要做的事情，会在这里写代码 （回调方法）
                if("sing".equals(method.getName())) {
                    System.out.println("准备话筒，收钱20万");
                }
                if("dance".equals(method.getName())) {
                    System.out.println("准备场地，收钱1000万");
                }
                return method.invoke(superStar, args);
            }
        });
        return proxy;
    }

    public static UserService createProxy(UserService userService) {


        /**
         *         newProxyInstance(ClassLoader loader,Class<?>[] interfaces,InvocationHandler h)
         *         参数1：用于指定一个类加载器
         *         参数2：指定生成的代理长什么样子，也就是有哪些方法
         *         参数3：用来指定生成的代理对象要干什么事情
         */
        UserService proxy = (UserService) Proxy.newProxyInstance(ProxyUtil.class.getClassLoader(), new Class[]{UserService.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                if("login".equals(method.getName()) || "deleteUsers".equals(method.getName()) || "selectUsers".equals(method.getName())) {
                    long startTime = System.currentTimeMillis();
                    method.invoke(userService, args);
                    long endTime = System.currentTimeMillis();
                    System.out.println(method.getName() + "方法耗时：" + (endTime - startTime) / 1000.0 + "s");
                }

                return method.invoke(userService, args);
            }
        });
        return proxy;
    }

}
