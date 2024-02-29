package com.hong.springbootstudy12demo.demos.web.proxy.service.impl;

import com.hong.springbootstudy12demo.demos.web.proxy.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public void login(String loginName, String password) throws Exception {
        long l = System.currentTimeMillis();

        if("admin".equals(loginName) && "123456".equals(password)) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }

    }

    @Override
    public void deleteUsers() throws Exception {
        System.out.println("删除成功");
        Thread.sleep(1500);
    }

    @Override
    public String[] selectUsers() throws Exception {
        System.out.println("查询出3个用户");
        String[] names = {"1", "2", "3"};
        Thread.sleep(1500);
        return names;
    }
}
