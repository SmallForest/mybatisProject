package com.yangsen.dao;

import com.yangsen.pojo.Teacher;
import com.yangsen.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.util.List;

public class TeacherMapperTest {
    //声明logger
    public static final Logger logger = LogManager.getLogger();

    @Test
    public void teacher() {
        //获取sqlSession
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            //获取mapper
            TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
            List<Teacher> list = mapper.teachers();
            for (Teacher u : list) {
                logger.info(u);
            }
        }
    }

    @Test
    public void getTeacherById() {
        //获取sqlSession
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            //获取mapper
            TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
            Teacher t = mapper.getTeacherById(1);
            logger.info(t);

        }
    }
    @Test
    public void getTeacherByIdSonQuery() {
        //获取sqlSession
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            //获取mapper
            TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
            Teacher t = mapper.getTeacherByIdSonQuery(1);
            logger.info(t);

        }
    }
}
