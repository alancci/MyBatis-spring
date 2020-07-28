package com.project.pojo;

import lombok.Data;
/**
 * @description 类(或接口)是
 * @author  haojiaxing
 * @date   2020/7/28 20:13
 **/
@Data
public class Student {
    private  int id;
    private String name;
    private int tid;
    //这里的参数Teacher 在一个老师对应多个学生的时候需要注释 返回null
    private Teacher teacher;

}
