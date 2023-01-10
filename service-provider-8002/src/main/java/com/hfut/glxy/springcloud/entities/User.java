package com.hfut.glxy.springcloud.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


@Setter
@Getter
@ToString
public class User {
    private Integer id;
    private String uname;
    private String pwd;
    private String email;
    private Integer role;

    private Cart cart;
    private List<OrderBean> orderBeanList;

    public User() {
    }
}
