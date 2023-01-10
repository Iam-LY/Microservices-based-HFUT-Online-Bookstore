package com.hfut.glxy.springcloud.service.impl;

import com.hfut.glxy.springcloud.entities.User;
import com.hfut.glxy.springcloud.mapper.UserMapper;
import com.hfut.glxy.springcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(String uname, String pwd) {
        User user = userMapper.getUser(uname, pwd);
        return user;
    }

    @Override
    public void register(User user) {
        userMapper.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }
}
