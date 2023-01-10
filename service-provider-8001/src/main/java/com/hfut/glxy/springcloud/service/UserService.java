package com.hfut.glxy.springcloud.service;

import com.hfut.glxy.springcloud.entities.User;

public interface UserService {

    //根据用户名、密码查询用户
    User getUser(String uname, String pwd);

    //用户注册
    void register(User user);

    //更新用户信息
    void updateUser(User user);
}
