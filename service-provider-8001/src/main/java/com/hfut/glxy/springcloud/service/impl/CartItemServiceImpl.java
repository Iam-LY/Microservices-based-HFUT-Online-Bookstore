package com.hfut.glxy.springcloud.service.impl;

import com.hfut.glxy.springcloud.entities.Cart;
import com.hfut.glxy.springcloud.entities.CartItem;
import com.hfut.glxy.springcloud.entities.User;
import com.hfut.glxy.springcloud.mapper.CartItemMapper;
import com.hfut.glxy.springcloud.service.CartItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Resource
    private CartItemMapper cartItemMapper;

    @Override
    public void addCartItem(CartItem cartItem) {
        cartItemMapper.addCartItem(cartItem);
    }

    @Override
    public void updateCartItem(CartItem cartItem) {
        cartItemMapper.updateCartItem(cartItem);
    }

    @Override
    public void addOrUpdateCartItem(CartItem cartItem, Cart cart) {
        //1.如果当前用户的购物车中已经存在这个图书了，那么将购物车中这本图书的数量+1
        //2.否则，在我的购物车中新增一个这本图书的CartItem，数量是1
        //判断当前用户的购物车中是否有这本书的CartItem，有->update , 无->add
        if (cart != null) {
            Map<Integer, CartItem> cartItemMap = cart.getCartItemMap();
            if (cartItemMap == null) {
                cartItemMap = new HashMap<>();
            }
            if (cartItemMap.containsKey(cartItem.getBook().getId())) {
                CartItem cartItemTemp = cartItemMap.get(cartItem.getBook().getId());
                cartItemTemp.setBuyCount(cartItemTemp.getBuyCount() + 1);
                updateCartItem(cartItemTemp);
            } else {
                addCartItem(cartItem);
            }
        } else {  //连购物车都没有的情况
            addCartItem(cartItem);
        }
    }

    @Override
    public void delCartItem(CartItem cartItem) {
        cartItemMapper.delCartItem(cartItem);
    }

    /**
     * 根据用户查询购物车，将用户id对应的购物项一个一个加到map集合中
     * @param user
     * @return
     */
    @Override
    public Cart getCart(User user) {
        List<CartItem> cartItemList = cartItemMapper.getCartItemList(user); //拿到用户id对应的所有购物项
        Map<Integer, CartItem> cartItemMap = new HashMap<>();
        for (CartItem cartItem : cartItemList) {
            cartItemMap.put(cartItem.getBook().getId(), cartItem); //加入购物项即书本的id和购物项对象
        }
        Cart cart = new Cart();
        cart.setCartItemMap(cartItemMap);
        return cart;
    }
}
