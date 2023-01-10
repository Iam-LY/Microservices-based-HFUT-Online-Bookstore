package com.hfut.glxy.springcloud.service;


import com.hfut.glxy.springcloud.entities.Cart;
import com.hfut.glxy.springcloud.entities.CartItem;
import com.hfut.glxy.springcloud.entities.User;
import com.hfut.glxy.springcloud.service.impl.CartItemServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "SERVICE-PROVIDER", fallback = CartItemServiceFallBack.class)
public interface CartItemService {

    @RequestMapping("/toCart")
    Cart getCart(@RequestBody User user);

    @RequestMapping("/addCart")
    void addCartItem(@RequestParam("bookId") Integer bookId, @RequestBody User user);

    @RequestMapping("/editCart")
    void updateCartItem(@RequestParam("cartItemId") Integer cartItemId, @RequestParam("buyCount") Integer buyCount);

    @RequestMapping("/delCartItem")
    void delCartItem(@RequestBody CartItem cartItem);
}

