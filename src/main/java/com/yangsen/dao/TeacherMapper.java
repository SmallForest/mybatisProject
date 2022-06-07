package com.yangsen.dao;

import com.yangsen.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper {
    @Select("select * from teacher")
    List<Teacher> teachers();

    Teacher getTeacherById(@Param("tid") int id);

    Teacher getTeacherByIdSonQuery(@Param("tid") int id);
}
