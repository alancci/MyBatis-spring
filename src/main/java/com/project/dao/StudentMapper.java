package com.project.dao;

import com.project.pojo.Student;
import com.project.pojo.Teacher;

import java.util.List;

public interface StudentMapper {
    List<Student> queryAllStudent();
    List<Student> queryAllStudent2();
    List<Teacher> getTeacher();
}
