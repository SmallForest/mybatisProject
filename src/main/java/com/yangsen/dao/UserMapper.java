package com.yangsen.dao;

import com.yangsen.pojo.User;

import java.util.List;

public interface UserMapper {
    //定义获取user列表的接口
    List<User> getUserList();
}
