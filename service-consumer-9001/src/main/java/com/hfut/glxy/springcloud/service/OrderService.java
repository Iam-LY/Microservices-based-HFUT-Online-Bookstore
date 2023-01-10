package com.hfut.glxy.springcloud.service;

import com.hfut.glxy.springcloud.entities.OrderBean;
import com.hfut.glxy.springcloud.entities.User;
import com.hfut.glxy.springcloud.service.impl.OrderServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Component
@FeignClient(value = "SERVICE-PROVIDER",fallback = OrderServiceFallBack.class)
public interface OrderService {

    @RequestMapping("/checkout")
    String checkout(@RequestBody User user);

    @RequestMapping("/myOrder")
    List<OrderBean> getOrderList(@RequestBody User user);

    @RequestMapping("/getOrder")
    OrderBean getOrder(@RequestParam("orderId") Integer orderId);

    @RequestMapping("/getAllOrder")
    List<OrderBean> getAllOrder();

    @RequestMapping("/deliver")
    String deliver(@RequestParam("id") Integer id);
}
