package com.hfut.glxy.springcloud.mapper;

import com.hfut.glxy.springcloud.entities.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    //根据用户名、密码查询用户
    User getUser(@Param("uname") String uname, @Param("pwd") String pwd);

    //根据用户id查询用户
    User getUserById(@Param("id") Integer id);

    //添加用户
    void addUser(@Param("user") User user);

    //跟新用户信息
    void updateUser(@Param("user") User user);
}
