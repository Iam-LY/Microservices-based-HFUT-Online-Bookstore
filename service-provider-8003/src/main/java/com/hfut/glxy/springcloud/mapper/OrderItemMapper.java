package com.hfut.glxy.springcloud.mapper;

import com.hfut.glxy.springcloud.entities.OrderItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderItemMapper {

    //添加订单项
    void addOrderItem(@Param("orderItem") OrderItem orderItem);

}
