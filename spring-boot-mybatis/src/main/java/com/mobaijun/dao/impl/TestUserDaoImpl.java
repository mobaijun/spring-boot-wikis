package com.mobaijun.dao.impl;

import com.mobaijun.dao.TestUserDao;
import com.mobaijun.entity.TestUser;
import com.mobaijun.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * Software：IntelliJ IDEA 2021.2 x64
 * Author: https://www.mobaijun.com
 * Date: 2022/1/10 9:56
 * ClassName:UserDaoImpl
 * 类描述： 接口实现类
 */
public class TestUserDaoImpl implements TestUserDao {

    private SqlSessionFactory sqlSessionFactory;

    /**
     * 通过构造方法注入
     */
    public TestUserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public TestUser findUserById(Integer id) {
        // sqlSession是线程不安全的，所以它的最佳使用范围在方法体内
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TestUserDao mapper = sqlSession.getMapper(TestUserDao.class);
        TestUser user = mapper.findUserById(id);
        sqlSession.close();
        return user;
    }

    @Override
    public List<TestUser> findUserByUserName(String name) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TestUserDao mapper = sqlSession.getMapper(TestUserDao.class);
        List<TestUser> userList = mapper.findUserByUserName(name);
        sqlSession.close();
        return userList;
    }

    @Override
    public int insertUser(TestUser user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TestUserDao mapper = sqlSession.getMapper(TestUserDao.class);
        int i = mapper.insertUser(user);
        sqlSession.commit();
        sqlSession.close();
        return i;
    }

    @Override
    public void updateUserById(TestUser user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TestUserDao mapper = sqlSession.getMapper(TestUserDao.class);
        mapper.updateUserById(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteUserById(Integer id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TestUserDao mapper = sqlSession.getMapper(TestUserDao.class);
        mapper.deleteUserById(id);
        sqlSession.commit();
        sqlSession.close();
    }
}
