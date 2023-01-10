package com.hfut.glxy.springcloud.controller;

import com.hfut.glxy.springcloud.entities.Cart;
import com.hfut.glxy.springcloud.entities.CartItem;
import com.hfut.glxy.springcloud.entities.User;
import com.hfut.glxy.springcloud.service.CartItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class CartItemController {

    @Resource
    private CartItemService cartItemService;

    /**
     * 根据当前用户获取购物车信息，跳转至购物车页面
     * @param session
     * @return
     */
    @RequestMapping("/toCart")
    public String toCart(HttpSession session) {
        User user = (User) session.getAttribute("currUser");
        Cart cart = cartItemService.getCart(user);
        if (cart.getCartItemMap()==null){
            return "fallback";
        }
        user.setCart(cart);
        session.setAttribute("currUser", user);
        return "cart/cart";
    }

    /**
     * 从前端页面接收bookId，向当前用户购物车添加该书
     * @param bookId
     * @param session
     * @return
     */
    @RequestMapping("/addCart/{bookId}")
    public String addCart(@PathVariable Integer bookId, HttpSession session) {
        User user = (User) session.getAttribute("currUser");
        cartItemService.addCartItem(bookId, user);
        return "redirect:/toIndex";
    }

    /**
     * 根据购物车的购物项id，修改购物车中书本的数量
     * @param cartItemId
     * @param buyCount
     * @return
     */
    @RequestMapping("/editCart")
    public String editCart(Integer cartItemId, Integer buyCount) {
        cartItemService.updateCartItem(cartItemId, buyCount);
        return "redirect:/toCart";
    }

    /**
     * 删除购物车中相应的购物项
     * @param cartItem
     * @return
     */
    @RequestMapping("/delCartItem")
    public String delCartItem(CartItem cartItem) {
        cartItemService.delCartItem(cartItem);
        return "redirect:/toCart";
    }
}


