package com.yangsen.dao;

import com.yangsen.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    //插入数据
    void addBlog(Blog b);

    //查询blogs
    List<Blog> getBlogsWithIF(Map<String,String> m);
}
