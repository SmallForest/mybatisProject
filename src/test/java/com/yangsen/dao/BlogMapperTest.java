package com.yangsen.dao;

import com.yangsen.pojo.Blog;
import com.yangsen.pojo.Student;
import com.yangsen.utils.MyBatisUtil;
import com.yangsen.utils.UUIDUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

public class BlogMapperTest {
    //声明logger
    public static final Logger logger = LogManager.getLogger();

    @Test
    public void addBlog(){
        //获取sqlSession
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            //获取mapper
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            Blog blog = new Blog(UUIDUtil.getUUID(),"中国近代史","smallForest", LocalDateTime.now(),1000);
            mapper.addBlog(blog);

            blog.setId(UUIDUtil.getUUID());
            blog.setTitle("高中语文");
            blog.setCreateTime(LocalDateTime.now());
            mapper.addBlog(blog);

            blog.setId(UUIDUtil.getUUID());
            blog.setTitle("大学物理");
            blog.setCreateTime(LocalDateTime.now());
            mapper.addBlog(blog);

            blog.setId(UUIDUtil.getUUID());
            blog.setTitle("信息技术教程");
            blog.setCreateTime(LocalDateTime.now());
            mapper.addBlog(blog);
            //增删改commit是必须的
            sqlSession.commit();
        }
    }
    @Test
    public void getBlogsWithIF(){
        //获取sqlSession
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            //获取mapper
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            HashMap<String,String> m = new HashMap<>();
            m.put("title","中国近代史");
            //m.put("author","mark");
            List<Blog> blog = mapper.getBlogsWithIF(m);
            for (Blog b : blog) {
                logger.info(b);
            }
        }
    }
}
