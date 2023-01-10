package com.hfut.glxy.springcloud.entities;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;

public class Cart {
    private Map<Integer, CartItem> cartItemMap;    //购物车中购物车项的集合 , 这个Map集合中的key是Book的id
    private Double totalMoney;                     //购物车的总金额
    private Integer totalCount;                    //购物车中购物项的数量
    private Integer totalBookCount;                //购物车中书本的总数量，而不是购物车项的总数量

    public Cart() {}


    public Cart(Map<Integer, CartItem> cartItemMap, Double totalMoney, Integer totalCount, Integer totalBookCount) {
        this.cartItemMap = cartItemMap;
        this.totalMoney = totalMoney;
        this.totalCount = totalCount;
        this.totalBookCount = totalBookCount;
    }


    public Map<Integer, CartItem> getCartItemMap() {
        return cartItemMap;
    }


    public Double getTotalMoney() {
        totalMoney = 0.0;
        if (cartItemMap != null && cartItemMap.size() > 0) {
            Set<Map.Entry<Integer, CartItem>> entries = cartItemMap.entrySet();
            for (Map.Entry<Integer, CartItem> cartItemEntry : entries) {
                CartItem cartItem = cartItemEntry.getValue();
                BigDecimal bigDecimalPrice = new BigDecimal("" + cartItem.getBook().getPrice());
                BigDecimal bigDecimalBuyCount = new BigDecimal("" + cartItem.getBuyCount());
                BigDecimal bigDecimalCartItemMoney = bigDecimalPrice.multiply(bigDecimalBuyCount);
                double CartItemMoney = bigDecimalCartItemMoney.doubleValue();
                totalMoney = totalMoney + CartItemMoney;
            }
        }
        return totalMoney;
    }

    public Integer getTotalCount() {
        totalCount = 0;
        if (cartItemMap != null && cartItemMap.size() > 0) {
            totalCount = cartItemMap.size();
        }
        return totalCount;
    }

    public Integer getTotalBookCount() {
        totalBookCount = 0;
        if (cartItemMap != null && cartItemMap.size() > 0) {
            for (CartItem cartItem : cartItemMap.values()) {
                totalBookCount += cartItem.getBuyCount();
            }
        }
        return totalBookCount;
    }

    public void setCartItemMap(Map<Integer, CartItem> cartItemMap) {
        this.cartItemMap = cartItemMap;
    }

    public void setTotalBookCount(Integer totalBookCount) {
        this.totalBookCount = totalBookCount;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartItemMap=" + cartItemMap +
                ", totalMoney=" + totalMoney +
                ", totalCount=" + totalCount +
                ", totalBookCount=" + totalBookCount +
                '}';
    }
}
