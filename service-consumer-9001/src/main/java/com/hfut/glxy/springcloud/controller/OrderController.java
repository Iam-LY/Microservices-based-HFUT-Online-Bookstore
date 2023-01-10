package com.hfut.glxy.springcloud.controller;

import com.hfut.glxy.springcloud.entities.OrderBean;
import com.hfut.glxy.springcloud.entities.User;
import com.hfut.glxy.springcloud.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class OrderController {

    @Resource
    private OrderService orderService;

    /**
     * 对当前用户购物车中的图书进行结账，并返回订单编号跳转至结账成功页面
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("/checkout")
    public String checkout(HttpSession session, Model model) {
        User user = (User) session.getAttribute("currUser");
        if (user.getCart().getTotalBookCount() == 0) {
            return "cart/cart";
        }
        String orderNo = orderService.checkout(user);
        model.addAttribute("orderNo", orderNo);
        return "cart/checkout";
    }

    /**
     * 查询当前用户所有订单并跳转至订单页面
     * @param session
     * @return
     */
    @RequestMapping("/myOrder")
    public String getOrderList(HttpSession session) {
        User user = (User) session.getAttribute("currUser");
        List<OrderBean> orderList = orderService.getOrderList(user);
        user.setOrderBeanList(orderList);
        session.setAttribute("currUser", user);
        return "order/order";
    }

    /**
     * 根据订单id查询相应订单的详细信息，跳转订单详情页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/getOrder")
    public String getOrder(Integer id, Model model) {
        OrderBean orderBean = orderService.getOrder(id);
        if (orderBean==null){
            return "fallback";
        }
        model.addAttribute("orderBean", orderBean);
        return "order/orderItem";
    }
}
