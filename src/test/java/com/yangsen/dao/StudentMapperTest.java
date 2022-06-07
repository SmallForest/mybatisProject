package com.yangsen.dao;

import com.yangsen.pojo.Student;
import com.yangsen.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.util.List;

public class StudentMapperTest {
    //声明logger
    public static final Logger logger = LogManager.getLogger();

    @Test
    public void getStudents(){
        //获取sqlSession
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            //获取mapper
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            List<Student> list = mapper.getStudents();
            for (Student s : list) {
                logger.info(s);
            }
        }
    }

    @Test
    public void getStudentsResult(){
        //获取sqlSession
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            //获取mapper
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            List<Student> list = mapper.getStudentsResult();
            for (Student s : list) {
                logger.info(s);
            }
        }
    }
}
