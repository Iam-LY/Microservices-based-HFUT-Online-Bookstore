package com.hfut.glxy.springcloud.controller;

import com.hfut.glxy.springcloud.entities.OrderBean;
import com.hfut.glxy.springcloud.entities.User;
import com.hfut.glxy.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    /**
     * 对相应用户的购物车结账，首先生成订单orderBean，再调用orderService进一步操作
     * @param user
     * @return
     */
    @RequestMapping("/checkout")
    public String checkout(@RequestBody User user) {
        OrderBean orderBean = new OrderBean();
        Date now = new Date();
        String orderNo = UUID.randomUUID().toString(); //随机赋一个订单号
        orderBean.setOrderNo(orderNo);
        orderBean.setOrderDate(now);
        orderBean.setOrderUser(user);
        orderBean.setOrderMoney(user.getCart().getTotalMoney());
        orderBean.setOrderStatus(0);
        orderService.addOrderBean(orderBean);
        return orderNo;
    }

    /**
     * 查询用户所有订单
     * @param user
     * @return
     */
    @RequestMapping("/myOrder")
    public List<OrderBean> getOrderList(@RequestBody User user) {
        List<OrderBean> orderList = orderService.getOrderList(user);
        return orderList;
    }

    /**
     * 根据id查询订单详情
     * @param orderId
     * @return
     */
    @RequestMapping("/getOrder")
    public OrderBean getOrderById(@RequestParam Integer orderId){
        OrderBean orderBean = orderService.getOrderById(orderId);
        return orderBean;
    }

    /**
     * 查询所有用户所有订单
     * @return
     */
    @RequestMapping("/getAllOrder")
    public List<OrderBean> getAllOrder(){
        List<OrderBean> allOrder = orderService.getAllOrder();
        return allOrder;
    }

    /**
     * 订单发货
     * @param id
     * @return
     */
    @RequestMapping("/deliver")
    public String deliver(@RequestParam Integer id){
        String deliver = orderService.deliver(id);
        return deliver;
    }
}