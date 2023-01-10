package com.hfut.glxy.springcloud.mapper;

import com.hfut.glxy.springcloud.entities.CartItem;
import com.hfut.glxy.springcloud.entities.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CartItemMapper {

    //添加购物车项
    void addCartItem(@Param("cartItem") CartItem cartItem);

    //更新购物车项
    void updateCartItem(@Param("cartItem") CartItem cartItem);

    //获取特定用户的所有购物车项
    List<CartItem> getCartItemList(@Param("user") User user);

    //删除特定的购物车项
    void delCartItem(@Param("cartItem") CartItem cartItem);
}
