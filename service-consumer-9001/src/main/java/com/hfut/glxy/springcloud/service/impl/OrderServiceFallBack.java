package com.hfut.glxy.springcloud.service.impl;

import com.hfut.glxy.springcloud.entities.OrderBean;
import com.hfut.glxy.springcloud.entities.User;
import com.hfut.glxy.springcloud.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class OrderServiceFallBack implements OrderService {
    @Override
    public String checkout(User user) {
        log.info("服务降级！！！！！！");
        return "服务降级！结账失败！";
    }

    @Override
    public List<OrderBean> getOrderList(User user) {
        log.info("服务降级！！！！！！");
        return null;
    }

    @Override
    public OrderBean getOrder(Integer orderId) {
        log.info("服务降级！！！！！！");
        return null;
    }

    @Override
    public List<OrderBean> getAllOrder() {
        log.info("服务降级！！！！！！");
        return null;
    }

    @Override
    public String deliver(Integer id) {
        log.info("服务降级！！！！！！");
        return "服务降级,发货失败！";
    }
}
