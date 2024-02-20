package com.hong.springbootstudy12demo.demos.web.test;

import org.junit.Test;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;
import org.springframework.core.metrics.StartupStep;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextTest {

    @Test
    public void test() {

        BufferingApplicationStartup bufferingApplicationStartup = new BufferingApplicationStartup(64);
        StartupStep oneStep = bufferingApplicationStartup.start("开始了第一件事情");
        oneStep.tag("第一步", "做了什么工作").tag("第二步", "干了什么事情").end();

        StartupStep secondStep = bufferingApplicationStartup.start("开始了第二件事情");
        secondStep.tag("第三步", "做了什么工作").tag("第四步", "干了什么事情").end();

    }

}
