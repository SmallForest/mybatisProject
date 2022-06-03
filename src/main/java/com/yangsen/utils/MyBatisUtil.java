package com.yangsen.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtil {
    private static SqlSessionFactory sqlSessionFactory;
    //静态代码块
    static {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        sqlSessionFactory =  new SqlSessionFactoryBuilder().build(inputStream);
    }
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }

}
