package com.hong.springbootstudy12demo.demos.web.test;

import com.hong.springbootstudy12demo.demos.web.event.OrderForEmailEvent;
import com.hong.springbootstudy12demo.demos.web.listener.EmailListener;
import com.hong.springbootstudy12demo.demos.web.listener.MessageListener;
import org.junit.Test;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;

@Component
public class SpringApplicationMultiCasterTest {

    @Test
    public void testMultiCaster() {

        SimpleApplicationEventMulticaster simpleApplicationEventMulticaster = new SimpleApplicationEventMulticaster();

        simpleApplicationEventMulticaster.setTaskExecutor(Executors.newFixedThreadPool(10));

        simpleApplicationEventMulticaster.addApplicationListener(new EmailListener());
        simpleApplicationEventMulticaster.addApplicationListener(new EmailListener());
        simpleApplicationEventMulticaster.addApplicationListener(new MessageListener());

        // 使用多播器发送事件
        simpleApplicationEventMulticaster.multicastEvent(new OrderForEmailEvent(this));

    }

}
