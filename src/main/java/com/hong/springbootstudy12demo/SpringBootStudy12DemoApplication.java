package com.hong.springbootstudy12demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@PropertySource("classpath:my.properties")
@EnableAsync
@EnableAspectJAutoProxy
//@EnableLoadTimeWeaving(aspectjWeaving = EnableLoadTimeWeaving.AspectJWeaving.DISABLED)
public class SpringBootStudy12DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStudy12DemoApplication.class, args);
    }

}
