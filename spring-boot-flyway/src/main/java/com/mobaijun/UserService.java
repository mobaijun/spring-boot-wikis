package com.mobaijun;

import java.util.List;

/**
 * Software：IntelliJ IDEA 2021.2 x64
 * Author: <a href="https://www.mobaijun.com">...</a>
 * Date: 2021/11/15 13:43
 * InterfaceName:UserService
 * 接口描述： 用户接口
 */
public interface UserService {
    /**
     * 新增一个用户
     */
    int create(String name, Integer age);

    /**
     * 根据name查询用户
     */
    List<User> getByName(String name);

    /**
     * 根据name删除用户
     */
    int deleteByName(String name);

    /**
     * 获取用户总量
     *
     * @return
     */
    Integer getAllUsers();

    /**
     * 删除所有用户
     */
    int deleteAllUsers();
}
