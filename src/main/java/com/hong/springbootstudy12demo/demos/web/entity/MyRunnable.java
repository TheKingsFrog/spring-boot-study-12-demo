package com.hong.springbootstudy12demo.demos.web.entity;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("MyRunnable running ..." + Thread.currentThread().getName());
    }
}
