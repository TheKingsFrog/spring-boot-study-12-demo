package com.hong.springbootstudy12demo;

import com.hong.springbootstudy12demo.demos.web.entity.MyRunnable;
import com.hong.springbootstudy12demo.demos.web.entity.MyThread;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

@SpringBootTest
public class ConcurrentTest {

    @Test
    public void test() {

        MyThread myThread = new MyThread(new MyRunnable());
        myThread.start();

        Thread thread = new MyThread(new MyRunnable());

        Collections.emptySortedMap();

    }

}
