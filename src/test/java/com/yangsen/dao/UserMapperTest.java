package com.yangsen.dao;

import com.github.pagehelper.PageHelper;
import com.yangsen.pojo.User;
import com.yangsen.utils.MyBatisUtil;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class UserMapperTest {
    //声明logger
    public static final Logger logger = LogManager.getLogger();

    @Test
    public void test() {
        //获取sqlSession 这样的写法，不用显式sqlSession.close(); 会自动关闭
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            //获取mapper
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            //执行查询
            List<User> userList = mapper.getUserList();
            for (User u : userList) {
                logger.info(u);
            }
        }

    }

    @Test
    public void getUserById() {
        //获取sqlSession
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            //获取mapper
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            //通过id=3获取用户信息
            User u = mapper.getUserById(3);
            logger.info(u);
        }
    }

    @Test
    public void addUser() {
        //获取sqlSession
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            //获取mapper
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            int num = mapper.addUser(new User(0, "麻子", "987665"));
            logger.info(num);
            //非常重要：增删改必须commit
            sqlSession.commit();
        }
    }

    @Test
    public void modifyUser() {
        //获取sqlSession
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            //获取mapper
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            mapper.modifyUser(new User(1, "张三丰", "999999"));
            //非常重要：增删改必须commit
            sqlSession.commit();
        }
    }

    @Test
    public void deleteUser() {
        //获取sqlSession
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            //获取mapper
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            mapper.deleteUser(7);
            //非常重要：增删改必须commit
            sqlSession.commit();
        }
    }

    @Test
    public void addUserByMap() {
        //获取sqlSession
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            //获取mapper
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            HashMap<String, Object> map = new HashMap<>();
            map.put("userid", 0);
            map.put("username", "春风");
            map.put("password", "034434");
            int num = mapper.addUserByMap(map);
            logger.info(num);
            //非常重要：增删改必须commit
            sqlSession.commit();
        }
    }

    @Test
    public void log4j2Test() {
        logger.info("测试");
        logger.warn("测试");
        logger.debug("测试");
        logger.error("测试");
    }

    @Test
    public void userListLimitAction() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            //获取mapper
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            HashMap<String, Integer> m = new HashMap<>();
            m.put("startIndex", 0);
            m.put("pageSize", 3);
            //执行查询
            List<User> userList = mapper.getUserListOfLimit(m);
            for (User u : userList) {
                logger.info(u);
            }
        }
    }

    @Test
    public void userListRowBoundsAction() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            RowBounds rb = new RowBounds(0, 3);
            //执行查询
            List<User> userList = sqlSession.selectList("com.yangsen.dao.UserMapper.getUserListOfRB", null, rb);
            for (User u : userList) {
                logger.info(u);
            }
        }
    }

    @Test
    public void userListPageHelper() {
        //获取sqlSession 这样的写法，不用显式sqlSession.close(); 会自动关闭
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            //获取mapper
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            //设置分页参数 页码1 每页数量10条
            PageHelper.startPage(1, 2);
            //执行查询 非常神奇的就是拦截器实现的无侵入分页
            List<User> userList = mapper.getUserList();
            for (User u : userList) {
                logger.info(u);
            }
        }
    }

    @Test
    public void getUserListAnnotation() {
        //获取sqlSession
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            //获取mapper
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            //设置分页参数 页码1 每页数量10条
            PageHelper.startPage(1, 2);
            //执行查询 非常神奇的就是拦截器实现的无侵入分页
            List<User> userList = mapper.getUserListAnnotation();
            for (User u : userList) {
                logger.info(u);
            }
        }
    }

    @Test
    public void getUserByIdAnnotation() {
        //获取sqlSession
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            //获取mapper
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            //执行查询
            User u = mapper.getUserByIdAnnotation(1);
            logger.info(u);
        }
    }
    @Test
    public void addUserAnnotation() {
        //获取sqlSession
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            //获取mapper
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            //执行查询
            mapper.addUserAnnotation(new User(0,"李飞","123345"));
            //提交还是不能忘记
            sqlSession.commit();
        }
    }

    @Test
    public void updateUserAnnotation() {
        //获取sqlSession
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            //获取mapper
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            //执行更新
            mapper.updateUserAnnotation(new User(13,"李飞飞","123456"));
            //提交还是不能忘记
            sqlSession.commit();
        }
    }

    @Test
    public void delUserAnnotation() {
        //获取sqlSession
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            //获取mapper
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            //删除 id=13
            mapper.delUserAnnotation(13);
            //提交还是不能忘记
            sqlSession.commit();
        }
    }
}
