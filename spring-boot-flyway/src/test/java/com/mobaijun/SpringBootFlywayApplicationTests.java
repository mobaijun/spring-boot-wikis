package com.mobaijun;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringBootFlywayApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
        userService.deleteAllUsers();
        // 添加5个用户
        userService.create("墨白", 18);
        userService.create("李白", 100);
        userService.create("张三", 100);
        userService.create("王五", 100);
        userService.create("李四", 100);

        // 查询墨白年龄是否匹配
        List<User> userList = userService.getByName("墨白");
        Assertions.assertEquals(18, userList.get(0).getAge().intValue());

        // 查询所有用户
        Assertions.assertEquals(5, userService.getAllUsers());
        // 删除两个用户
        userService.deleteByName("王五");
        userService.deleteByName("李四");
    }
}
