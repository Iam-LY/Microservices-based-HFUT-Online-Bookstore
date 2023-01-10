package com.hfut.glxy.springcloud.mapper;

import com.hfut.glxy.springcloud.entities.OrderBean;
import com.hfut.glxy.springcloud.entities.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {
    //添加订单
    int addOrderBean(@Param("orderBean") OrderBean orderBean);

    //获取指定用户订单列表
    List<OrderBean> getOrderList(@Param("user") User user);

    //获取所有订单列表
    List<OrderBean> getAllOrder();

    //获取指定订单书本数量
    Integer getOrderTotalBookCount(@Param("orderBeanId") Integer orderBeanId);

    //获取指定用户订单列表
    OrderBean getOrderById(@Param("OrderId") Integer OrderId);

    //订单发货
    void deliver(@Param("id") Integer id);

}
