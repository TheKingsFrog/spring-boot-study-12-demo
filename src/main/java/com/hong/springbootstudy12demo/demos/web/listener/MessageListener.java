package com.hong.springbootstudy12demo.demos.web.listener;

import com.hong.springbootstudy12demo.demos.web.event.OrderForEmailEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


@Component
public class MessageListener implements ApplicationListener<OrderForEmailEvent> {


    @Override
    public void onApplicationEvent(OrderForEmailEvent event) {
        System.out.println("当前线程：" + Thread.currentThread().getName());
        System.out.println(event.getSource() + "-->短信发送了!");
    }

}
