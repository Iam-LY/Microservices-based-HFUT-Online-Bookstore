package com.hfut.glxy.springcloud.service.impl;

import com.hfut.glxy.springcloud.entities.Book;
import com.hfut.glxy.springcloud.entities.Cart;
import com.hfut.glxy.springcloud.entities.CartItem;
import com.hfut.glxy.springcloud.entities.User;
import com.hfut.glxy.springcloud.service.CartItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class CartItemServiceFallBack implements CartItemService {
    @Override
    public Cart getCart(User user) {
        log.info("服务降级！！！！！！");
        Cart cart = new Cart();
//        Map<Integer, CartItem> map = new HashMap<>();
//        CartItem cartItem = new CartItem();
//        cartItem.setBook(new Book());
//        map.put(1, cartItem);
//        cart.setCartItemMap(map);
        return cart;
    }

    @Override
    public void addCartItem(Integer bookId, User user) {
        log.info("服务降级！！！！！！");
    }

    @Override
    public void updateCartItem(Integer cartItemId, Integer buyCount) {
        log.info("服务降级！！！！！！");
    }

    @Override
    public void delCartItem(CartItem cartItem) {
        log.info("服务降级！！！！！！");
    }
}
