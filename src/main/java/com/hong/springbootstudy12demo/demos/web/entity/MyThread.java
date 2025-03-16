package com.hong.springbootstudy12demo.demos.web.entity;

public class MyThread extends Thread {
    public MyThread(MyRunnable myRunnable) {

    }

    @Override
    public void run() {
        System.out.println("MyThread running...");
        super.run();
    }
}
