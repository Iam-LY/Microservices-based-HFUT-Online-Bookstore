package com.hfut.glxy.springcloud.controller;

import com.hfut.glxy.springcloud.entities.Book;
import com.hfut.glxy.springcloud.entities.Cart;
import com.hfut.glxy.springcloud.entities.CartItem;
import com.hfut.glxy.springcloud.entities.User;
import com.hfut.glxy.springcloud.service.CartItemService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
public class CartItemController {

    @Resource
    private CartItemService cartItemService;

    /**
     * 查询相应用户的购物车信息
     * @param user
     * @return
     */
    @RequestMapping("/toCart")
    public Cart getCart(@RequestBody User user) {
        Cart cart = cartItemService.getCart(user);
        return cart;
    }

    /**
     * 添加图书至相应用户购物车
     * @param bookId
     * @param user
     * @return
     */
    @RequestMapping("/addCart")
    public String addCartItem(@RequestParam Integer bookId, @RequestBody User user) {
        CartItem cartItem = new CartItem(new Book(bookId), 1, user);
        cartItemService.addOrUpdateCartItem(cartItem, user.getCart());
        return "ok";
    }

    /**
     * 修改书本购买数量
     * @param cartItemId
     * @param buyCount
     * @return
     */
    @RequestMapping("/editCart")
    public String editCart(@RequestParam Integer cartItemId, @RequestParam Integer buyCount) {
        cartItemService.updateCartItem(new CartItem(cartItemId, buyCount));
        return "ok";
    }

    /**
     * 删除购物车中的书本
     * @param cartItem
     * @return
     */
    @RequestMapping("/delCartItem")
    public String delCartItem(@RequestBody CartItem cartItem) {
        cartItemService.delCartItem(cartItem);
        return "ok";
    }
}