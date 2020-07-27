package com.project.dao;

import com.project.pojo.User;

import java.util.List;

public interface UserMapper {
    /**
     * @description 类(或接口)是
     * @author  haojiaxing
     * @date   2020/7/27 11:06
     **/

    int addUser(User user);
    int deleteUser(Integer userID);
    List<User> queryAllUser();

}
