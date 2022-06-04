package com.yangsen.dao;

import com.yangsen.pojo.User;
import com.yangsen.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class UserMapperTest {
    @Test
    public void test() {
        //获取sqlSession
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        //获取mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //执行查询
        List<User> userList = mapper.getUserList();
        for (User u : userList) {
            System.out.println(u);
        }
        sqlSession.close();
    }

    @Test
    public void getUserById() {
        //获取sqlSession
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        //获取mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //通过id=3获取用户信息
        User u = mapper.getUserById(3);
        System.out.println(u);
        sqlSession.close();
    }

    @Test
    public void addUser() {
        //获取sqlSession
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        //获取mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int num = mapper.addUser(new User(0, "麻子", "987665"));
        System.out.println(num);
        //非常重要：增删改必须commit
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void modifyUser() {
        //获取sqlSession
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        //获取mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.modifyUser(new User(1, "张三丰", "999999"));
        //非常重要：增删改必须commit
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUser() {
        //获取sqlSession
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        //获取mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser(7);
        //非常重要：增删改必须commit
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void addUserByMap() {
        //获取sqlSession
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        //获取mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String, Object> map = new HashMap<>();
        map.put("userid",0);
        map.put("username","春风");
        map.put("password","034434");
        int num = mapper.addUserByMap(map);
        System.out.println(num);
        //非常重要：增删改必须commit
        sqlSession.commit();
        sqlSession.close();
    }
}
