package com.hfut.glxy.springcloud.service;

import com.hfut.glxy.springcloud.entities.OrderBean;
import com.hfut.glxy.springcloud.entities.User;

import java.util.List;

public interface OrderService {

    //添加订单
    void addOrderBean(OrderBean orderBean);

    //获取指定用户订单列表
    List<OrderBean> getOrderList(User user);

    //获取所有订单列表
    List<OrderBean> getAllOrder();

    //获取指定用户订单列表
    OrderBean getOrderById(Integer OrderId);

    //订单发货
    String deliver(Integer id);

}
