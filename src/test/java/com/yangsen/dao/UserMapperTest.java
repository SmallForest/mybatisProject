package com.yangsen.dao;

import com.yangsen.pojo.User;
import com.yangsen.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest
{
    @Test
    public void test(){
        //获取sqlSession
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        //获取mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //执行查询
        List<User> userList = mapper.getUserList();
        for (User u:userList) {
            System.out.println(u);
        }
        sqlSession.close();
    }
}
