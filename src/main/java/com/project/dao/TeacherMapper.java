package com.project.dao;

import com.project.pojo.Student;
import com.project.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {
    List<Teacher> queryAllTeacher(@Param("tid") Integer id);
    List<Teacher> queryAllTeacher2(@Param("tid") Integer id);
    List<Student> getStudentByTid(@Param("id") Integer id);
}
