package com.hfut.glxy.springcloud.controller;

import com.hfut.glxy.springcloud.entities.Book;
import com.hfut.glxy.springcloud.entities.Cart;
import com.hfut.glxy.springcloud.entities.User;
import com.hfut.glxy.springcloud.service.BookService;
import com.hfut.glxy.springcloud.service.CartItemService;
import com.hfut.glxy.springcloud.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private CartItemService cartItemService;
    @Resource
    private BookService bookService;

    /**
     * 查询所有图书，跳转至商城首页
     * @param session
     * @return
     */
    @RequestMapping({"/index", "/"})
    public String index(HttpSession session) {
        List<Book> bookList = bookService.getBookList();
        session.setAttribute("bookList", bookList);
        return "index";
    }

    /**
     * 用户登录，若用户名和密码验证成功，则将当前用户存入session中
     * @param uname
     * @param pwd
     * @param session
     * @return
     */
    @RequestMapping("/login")
    public String login(String uname, String pwd, HttpSession session) {
        User user = userService.getUser(uname, pwd);
        if (user != null) {
            session.setAttribute("currUser", user);
            return "redirect:/index";
        }
        return "user/login";
    }

    /**
     * 退出当前用户
     * @param session
     * @return
     */
    @RequestMapping("/loginOut")
    public String loginOut(HttpSession session) {
        session.invalidate();
        return "redirect:/index";
    }

    /**
     * 更新当前用户页面缓存的购物车信息，并返回商城首页
     * @return
     */
    @RequestMapping("/toIndex")
    public String toIndex(HttpSession session) {
        User user = (User) session.getAttribute("currUser");
        Cart cart = cartItemService.getCart(user);
        if (cart.getCartItemMap() == null) {
            return "fallback";
        }
        user.setCart(cart);
        session.setAttribute("currUser", user);
        return "redirect:/index";
    }

    /**
     * 用户注册，验证两次密码输入是否一致及验证码是否正确
     * @param verifyCode
     * @param user
     * @param pwd2
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("/register")
    public String register(String verifyCode, User user, String pwd2, HttpSession session, Model model) {
        System.out.println(user);
        Object kaptchaSessionKey = session.getAttribute("verifyCode");
        if (kaptchaSessionKey == null || !verifyCode.equals(kaptchaSessionKey)) {
            model.addAttribute("msg", 1);
            return "user/regist";
        } else if (!pwd2.equals(user.getPwd())) {
            model.addAttribute("msg", 2);
            return "user/regist";
        } else if (verifyCode.equals(kaptchaSessionKey)) {
            userService.register(user);
            return "user/login";
        }
        return "user/regist";
    }

    /**
     * 用户信息修改
     * @param verifyCode
     * @param user
     * @param pwd2
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("/updateUser")
    public String updateUser(String verifyCode, User user, String pwd2, HttpSession session, Model model) {
        Object kaptchaSessionKey = session.getAttribute("verifyCode");
        if (kaptchaSessionKey == null || !verifyCode.equals(kaptchaSessionKey)) {
            model.addAttribute("msg", 1);
            return "user/edit";
        } else if (!pwd2.equals(user.getPwd())) {
            model.addAttribute("msg", 2);
            return "user/edit";
        } else if (verifyCode.equals(kaptchaSessionKey)) {
            userService.updateUser(user);
            session.invalidate();
            return "user/login";
        }
        return "user/edit";
    }
}
