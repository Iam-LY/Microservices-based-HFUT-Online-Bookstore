package com.hfut.glxy.springcloud.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.ToString;

import java.math.BigDecimal;

@ToString
public class OrderItem {
    private Integer id;
    private Book book;                 //M:1
    private Integer buyCount;
    private OrderBean orderBean;       //M:1   订单项所属的订单

    @JsonIgnore
    private Double orderItemMoney;  //

    public OrderItem(Integer id) {
        this.id = id;
    }

    public OrderItem() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Integer buyCount) {
        this.buyCount = buyCount;
    }

    public OrderBean getOrderBean() {
        return orderBean;
    }

    public void setOrderBean(OrderBean orderBean) {
        this.orderBean = orderBean;
    }

    public Double getOrderItemMoney() {
        BigDecimal bigDecimalPrice = new BigDecimal("" + getBook().getPrice());
        BigDecimal bigDecimalBuyCount = new BigDecimal("" + buyCount);
        BigDecimal bigDecimalXJ = bigDecimalPrice.multiply(bigDecimalBuyCount);
        orderItemMoney = bigDecimalXJ.doubleValue();
        return orderItemMoney;
    }

    public void setOrderItemMoney(Double orderItemMoney) {
        this.orderItemMoney = orderItemMoney;
    }

}
