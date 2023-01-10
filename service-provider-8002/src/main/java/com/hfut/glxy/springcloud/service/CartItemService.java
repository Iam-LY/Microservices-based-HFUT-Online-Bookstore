package com.hfut.glxy.springcloud.service;


import com.hfut.glxy.springcloud.entities.Cart;
import com.hfut.glxy.springcloud.entities.CartItem;
import com.hfut.glxy.springcloud.entities.User;

public interface CartItemService {

    //添加购物车项
    void addCartItem(CartItem cartItem);

    //更新购物车项
    void updateCartItem(CartItem cartItem);

    //添加或更新购物车项
    void addOrUpdateCartItem(CartItem cartItem, Cart cart);

    //删除特定的购物车项
    void delCartItem(CartItem cartItem);

    //加载特定用户的购物车信息
    Cart getCart(User user);
}

