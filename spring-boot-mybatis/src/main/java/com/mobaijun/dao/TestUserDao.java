package com.mobaijun.dao;

import com.mobaijun.entity.TestUser;
import com.mobaijun.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Software：IntelliJ IDEA 2021.2 x64
 * Author: https://www.mobaijun.com
 * Date: 2022/1/7 15:48
 * InterfaceName:UserDao
 * 接口描述： dao接口
 */
@Mapper
public interface TestUserDao {

    /**
     * 通过ID查询一个用户
     */
    TestUser findUserById(@Param("id") Integer id);

    /**
     * 根据用户名模糊查询用户列表
     */
    List<TestUser> findUserByUserName(@Param("name") String name);

    /**
     * 添加用户
     */
    int insertUser(TestUser user);

    /**
     * 更新用户
     */
    void updateUserById(TestUser user);

    /**
     * 删除用户
     */
    void deleteUserById(@Param("id") Integer id);
}
