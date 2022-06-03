package com.yangsen.dao;

import com.yangsen.pojo.User;

import java.util.List;

public interface UserMapper {
    //定义获取user列表的接口
    List<User> getUserList();

    //通过id获取user信息
    User getUserById(int id);

    //增加用户
    int addUser(User u);
}
