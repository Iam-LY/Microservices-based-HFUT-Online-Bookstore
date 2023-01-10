package com.hfut.glxy.springcloud.service;

import com.hfut.glxy.springcloud.entities.User;
import com.hfut.glxy.springcloud.service.impl.UserServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "SERVICE-PROVIDER", fallback = UserServiceFallBack.class)
public interface UserService {

    @RequestMapping("/login")
    User getUser(@RequestParam("uname") String uname, @RequestParam("pwd") String pwd);

    @RequestMapping("/register")
    void register(User user);

    @RequestMapping("/updateUser")
    void updateUser(User user);
}
