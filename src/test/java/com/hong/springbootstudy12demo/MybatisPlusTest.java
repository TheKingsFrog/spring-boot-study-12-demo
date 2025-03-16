package com.hong.springbootstudy12demo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hong.springbootstudy12demo.demos.web.entity.User;
import com.hong.springbootstudy12demo.demos.web.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class MybatisPlusTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void test1() {

        List<User> users = userMapper.selectList(null);

        users.forEach(System.out::println);

    }

    @Test
    public void test2() {

        User user = userMapper.selectById(5);

        user.setBalance(user.getBalance().add(BigDecimal.ONE));

        userMapper.updateById(user);

    }

    @Test
    public void test3() {

        User user = userMapper.selectById(5);

        user.setBalance(user.getBalance().add(BigDecimal.TEN));

        userMapper.updateById(user);

    }

    @Test
    public void test4() {

        Page<User> userPage = new Page<>(1, 5);

        userPage = userMapper.selectPage(userPage, null);

        userPage.getRecords().forEach(System.out::println);

    }

}
