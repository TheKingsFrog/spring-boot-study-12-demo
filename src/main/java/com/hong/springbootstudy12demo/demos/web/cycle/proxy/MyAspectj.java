package com.hong.springbootstudy12demo.demos.web.cycle.proxy;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspectj {

    @Before("execution(* com.hong.springbootstudy12demo.demos.web.cycle.*.*(..))")
    public void before() {
        System.out.println("**********before**********");
    }

}
