package com.hong.springbootstudy12demo.demos.web.service;

import com.hong.springbootstudy12demo.demos.web.dao.UserDao;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserDao userDao;

    /**
     * 显示注入（带@Autowired注解）
     * @param userDao
     */
    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * 隐式注入（不带@Autowired注解）
     * 如果隐式注入的参数未被spring管理（没有带上容器注解），就会报错找不到该类
     * @param userDao
     */
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * 这时候ObjectProvider就发挥了作用，解决了上面的问题。构造函数带上ObjectProvider参数，如果维护的对象不是bean，则就不会报错，直接传个空
     * @param userDao
     */
    public UserService(ObjectProvider<UserDao> userDao) {
        this.userDao = userDao.getIfUnique();
    }



    /**
     * 隐式注入需要保证只有一个构造函数，如果有多个构造函数，spring不知道该拿哪一个做构造，会导致隐式注入失败
     */
    public UserService() {}

    @Override
    public String toString() {
        return "UserService{" +
                "userDao=" + userDao +
                '}';
    }
}
