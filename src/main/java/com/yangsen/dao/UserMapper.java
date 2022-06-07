package com.yangsen.dao;

import com.yangsen.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //定义获取user列表的接口
    List<User> getUserList();

    //通过id获取user信息
    User getUserById(int id);

    //增加用户
    int addUser(User u);

    //编辑用户信息
    void modifyUser(User u);

    //删除用户by id 这只是删除的一种方式
    void deleteUser(int id);

    //增加用户，map当做参数
    int addUserByMap(Map<String,Object> m);

    List<User> getUserListOfLimit(Map<String,Integer> m);

    List<User> getUserListOfRB();

    @Select("select * from user")
    List<User> getUserListAnnotation();

    @Select("select * from user where id=#{uid}")
    User getUserByIdAnnotation(@Param("uid") int id);

    @Insert("insert into user(id,name,pwd) values(#{id},#{name},#{password})")
    void addUserAnnotation(User u);

    @Update("update user set name=#{name},pwd=#{password} where id=#{id}")
    void updateUserAnnotation(User u);

    @Delete("delete from user where id=#{delId}")
    void delUserAnnotation(@Param("delId") int id);
}
