package com.hfut.glxy.springcloud.controller;


import com.hfut.glxy.springcloud.entities.Cart;
import com.hfut.glxy.springcloud.entities.User;
import com.hfut.glxy.springcloud.service.CartItemService;
import com.hfut.glxy.springcloud.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private CartItemService cartItemService;

    /**
     * 用户登录，并查询用户购物车信息
     * @param uname
     * @param pwd
     * @return
     */
    @RequestMapping("/login")
    public User getUser(@RequestParam String uname, @RequestParam String pwd) {
        User user = userService.getUser(uname, pwd);
        if (user != null) {
            Cart cart = cartItemService.getCart(user);
            user.setCart(cart);
            return user;
        }
        return null;
    }

    /**
     * 用户注册
     * @param user
     */
    @RequestMapping("/register")
    public void register(@RequestBody User user) {
        userService.register(user);
    }

    /**
     * 用户信息更新
     * @param user
     */
    @RequestMapping("/updateUser")
    void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }
}
