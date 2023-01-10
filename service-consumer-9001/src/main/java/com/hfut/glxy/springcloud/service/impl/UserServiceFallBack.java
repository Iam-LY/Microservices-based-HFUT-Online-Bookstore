package com.hfut.glxy.springcloud.service.impl;

import com.hfut.glxy.springcloud.entities.User;
import com.hfut.glxy.springcloud.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserServiceFallBack implements UserService {
    @Override
    public User getUser(String uname, String pwd) {
        log.info("服务降级！！！！！！");
        return null;
    }

    @Override
    public void register(User user) {
        log.info("服务降级！！！！！！");
    }

    @Override
    public void updateUser(User user) {
        log.info("服务降级！！！！！！");
    }
}
