package com.hfut.glxy.springcloud.entities;

import lombok.ToString;

import java.util.Date;
import java.util.List;

@ToString
public class OrderBean {
    private Integer id;
    private String orderNo;   //订单号
    private Date orderDate;
    private User orderUser;
    private Double orderMoney;   //订单总金额
    private Integer orderStatus; // 订单状态：0等待发货 ， 1已发货
    private Integer totalBookCount; //该订单的书本数量
    private List<OrderItem> orderItemList;     //1:N，  订单包含的订单项

    public OrderBean(Integer id) {
        this.id = id;
    }

    public OrderBean() {
    }

    public Integer getId() {
        return id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public User getOrderUser() {
        return orderUser;
    }

    public Double getOrderMoney() {
        return orderMoney;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public Integer getTotalBookCount() {
        return totalBookCount;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setOrderUser(User orderUser) {
        this.orderUser = orderUser;
    }

    public void setOrderMoney(Double orderMoney) {
        this.orderMoney = orderMoney;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public void setTotalBookCount(Integer totalBookCount) {
        this.totalBookCount = totalBookCount;
    }
}
