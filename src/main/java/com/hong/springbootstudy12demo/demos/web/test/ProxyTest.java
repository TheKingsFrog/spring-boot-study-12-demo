package com.hong.springbootstudy12demo.demos.web.test;


import com.hong.springbootstudy12demo.demos.web.cycle.A;
import com.hong.springbootstudy12demo.demos.web.proxy.Star;
import com.hong.springbootstudy12demo.demos.web.proxy.SuperStar;
import com.hong.springbootstudy12demo.demos.web.proxy.handler.TraceHandler;
import com.hong.springbootstudy12demo.demos.web.proxy.service.UserService;
import com.hong.springbootstudy12demo.demos.web.proxy.service.impl.UserServiceImpl;
import com.hong.springbootstudy12demo.demos.web.proxy.util.ProxyUtil;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ProxyTest {

    @Test
    public void test() {

        Object[] objects = new Object[1000];

        for (int i = 0; i < objects.length; i++) {
            Integer var = i + 1;
            // construct wrapper
            TraceHandler traceHandler = new TraceHandler(var);
            // construct proxy for one or more interfaces
            objects[i] = Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Comparable.class}, traceHandler);
        }

        Integer key = new Random().nextInt(objects.length) + 1;

        int result = Arrays.binarySearch(objects, key);

        if(result >= 0) {
            System.out.println(objects[result]);
        }

    }

    @Test
    public void test2() {
        SuperStar superStar = new SuperStar("杨超越");
        Star proxy = ProxyUtil.createProxy(superStar);
        System.out.println(proxy.sing("好日子"));
        proxy.dance();

    }
    @Test
    public void test3() throws Exception {
        UserService userService = new UserServiceImpl();
        UserService proxy = ProxyUtil.createProxy(userService);
        proxy.login("admin", "123456");
        System.out.println("-------------------------------");
        proxy.deleteUsers();
        System.out.println("-------------------------------");
        String[] strings = proxy.selectUsers();
        System.out.println("查询到用户：" + Arrays.toString(strings));
        System.out.println("-------------------------------");


    }

}
