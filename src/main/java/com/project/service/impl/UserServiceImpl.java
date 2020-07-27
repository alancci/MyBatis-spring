package com.project.service.impl;

import com.project.dao.UserMapper;
import com.project.pojo.User;
import com.project.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class UserServiceImpl implements UserService {
    private SqlSessionTemplate sqlSession;

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }


    public List<User> queryAllUser() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        return mapper.queryAllUser();
    }
//    public User getUser(String userId) {
//        return sqlSession.getMapper...;
//    }
}
