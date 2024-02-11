package com.hong.springbootstudy12demo.demos.web.listener;

import com.hong.springbootstudy12demo.demos.web.event.OrderEvent;
import com.hong.springbootstudy12demo.demos.web.event.OrderForEmailEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class EmailListener implements ApplicationListener<OrderForEmailEvent> {


    @Override
    public void onApplicationEvent(OrderForEmailEvent event) {
        System.out.println("当前线程：" + Thread.currentThread().getName());
        System.out.println(event.getSource() + "-->邮件发送了!");
    }
}
