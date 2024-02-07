package com.hong.springbootstudy12demo.demos.web.spring;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class Test2EventListener {

    @EventListener
    @Async
    public void test(TestApplicationEvent testApplicationEvent) throws InterruptedException {
        Thread.sleep(2000);
       log.info("【Test2EventListener】监听到数据：{}", testApplicationEvent.getMessage());
    }

}
