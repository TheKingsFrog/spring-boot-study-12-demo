package com.hong.springbootstudy12demo.demos.web.proxy;

public class SuperStar implements Star {

    private String name;

    public SuperStar(String name) {
        this.name = name;
    }

    @Override
    public String sing(String name) {
        System.out.println(this.name + "正在唱：" + name);
        return "谢谢！谢谢";
    }

    @Override
    public void dance() {
        System.out.println(this.name + "正在优美地跳舞~~");
    }

}
