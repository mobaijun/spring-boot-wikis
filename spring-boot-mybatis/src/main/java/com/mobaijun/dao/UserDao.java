package com.mobaijun.dao;

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
public interface UserDao {
    /**
     * 查询
     */
    List<User> findByid(@Param("id") int id);

    /**
     * 删除
     */
    int deleteById(@Param("id") int id);

    /**
     * 添加
     */
    int saveUser(User user);

    /**
     * 查询全部
     */
    List<User> findAll();
}
