package com.yangsen.dao;

import com.yangsen.pojo.Student;

import java.util.List;

public interface StudentMapper {

    List<Student> getStudents();

    List<Student> getStudentsResult();
}
