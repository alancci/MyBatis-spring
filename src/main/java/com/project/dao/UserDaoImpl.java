package com.project.dao;

import com.project.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserMapper {


    public int addUser(User user) {
        UserMapper userMapper = getSqlSession().getMapper(UserMapper.class);
        return userMapper.addUser(user);
    }


    public int deleteUser(Integer userID) {
        UserMapper userMapper = getSqlSession().getMapper(UserMapper.class);
        return userMapper.deleteUser(userID);
    }

    public List<User> queryAllUser() {
        /**
         * @description  Mybais整合实现方式二  直接getSqlSession() 修改配置文件对应的dao 中property 为sqlSessionFactory
         * @author  haojiaxing
         * @date   2020/7/27 10:50
         * @return      java.util.List<com.project.pojo.User>
         * @Exception
         **/
        UserMapper userMapper = getSqlSession().getMapper(UserMapper.class);
        User user = new User(4,"小明","123456");
        userMapper.addUser(user);
        userMapper.deleteUser(4);
        return userMapper.queryAllUser();
    }


/*
 整合实现方式一
    private SqlSessionTemplate sqlSession;

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<User> queryAllUser() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        return mapper.queryAllUser();
    }*/
}
