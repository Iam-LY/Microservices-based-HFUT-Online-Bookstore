package com.hfut.glxy.springcloud.service.impl;

import com.hfut.glxy.springcloud.entities.CartItem;
import com.hfut.glxy.springcloud.entities.OrderBean;
import com.hfut.glxy.springcloud.entities.OrderItem;
import com.hfut.glxy.springcloud.entities.User;
import com.hfut.glxy.springcloud.mapper.CartItemMapper;
import com.hfut.glxy.springcloud.mapper.OrderItemMapper;
import com.hfut.glxy.springcloud.mapper.OrderMapper;
import com.hfut.glxy.springcloud.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private OrderItemMapper orderItemMapper;

    @Resource
    private CartItemMapper cartItemMapper;

    //结账
    @Transactional
    @Override
    public void addOrderBean(OrderBean orderBean) {
        // 1  添加订单
        orderMapper.addOrderBean(orderBean); //执行完orderBean中的id有值
        // 2  添加订单项
        User currUser = orderBean.getOrderUser();
        Map<Integer, CartItem> cartItemMap = currUser.getCart().getCartItemMap();
        for (CartItem cartItem : cartItemMap.values()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setBook(cartItem.getBook());
            orderItem.setBuyCount(cartItem.getBuyCount());
            orderItem.setOrderBean(orderBean);
            orderItemMapper.addOrderItem(orderItem);
        }
        // 3  清空购物车
        for (CartItem cartItem : cartItemMap.values()) {
            cartItemMapper.delCartItem(cartItem);
        }
    }

    @Override
    public List<OrderBean> getOrderList(User user) {
        List<OrderBean> orderList = orderMapper.getOrderList(user);
        return orderList;
    }

    @Override
    public List<OrderBean> getAllOrder() {
        return orderMapper.getAllOrder();
    }

    @Override
    public OrderBean getOrderById(Integer OrderId) {
        OrderBean orderBean = orderMapper.getOrderById(OrderId);
        return orderBean;
    }

    @Override
    public String deliver(Integer id) {
        orderMapper.deliver(id);
        return "发货成功！";
    }
}
