package com.hong.springbootstudy12demo.demos.web.proxy.service;

public interface UserService {

    /**
     * 登录功能
     * @param loginName
     * @param password
     * @throws Exception
     */
    void login(String loginName, String password) throws Exception;

    /**
     * 删除用户
     * @throws Exception
     */
    void deleteUsers() throws Exception;

    /**
     * 查询用户，返回数组的形式
     * @return {@link String[]}
     * @throws Exception
     */
    String[] selectUsers() throws Exception;


}
