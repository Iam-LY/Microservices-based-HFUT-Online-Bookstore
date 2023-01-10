package com.hfut.glxy.springcloud;


import com.hfut.glxy.springcloud.entities.Book;
import com.hfut.glxy.springcloud.entities.OrderBean;
import com.hfut.glxy.springcloud.entities.User;
import com.hfut.glxy.springcloud.mapper.OrderMapper;
import com.hfut.glxy.springcloud.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;


@SpringBootTest
class SpringbootBookApplicationTests {


    @Autowired
    OrderService orderMapper;


    @Test
    void contextLoads() {
        User user = new User();
        user.setId(1);
//        List<OrderBean> orderList = orderMapper.getOrderList(user);
        OrderBean orderById = orderMapper.getOrderById(2);

//        OrderBean orderBean = orderMapper.getOrderById(1);
        System.out.println("-----------------------------------------");
        System.out.println(orderById);
        System.out.println("-----------------------------------------");

    }

}

