package com.mobaijun.test;

import com.mobaijun.dao.TestUserDao;
import com.mobaijun.dao.impl.TestUserDaoImpl;
import com.mobaijun.entity.TestUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Software：IntelliJ IDEA 2021.2 x64
 * Author: https://www.mobaijun.com
 * Date: 2022/1/10 10:18
 * ClassName:UserDaoTest
 * 类描述：
 */
@Slf4j
@SpringBootTest
public class UserDaoTest {

    private TestUserDao userDao;

    /**
     * 通过Id查询一个用户
     */
    @Test
    public void testFindUserById() throws Exception {
        // 1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2.创建SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 将初始化好的工厂注入到实现类中
        TestUserDao userdao = new TestUserDaoImpl(factory);
        TestUser user = userdao.findUserById(1);
        System.out.println(user);
        // TestUser(id=1, account=mobai123, name=mobaijun, password=123456)
    }

    //根据用户名模糊查询用户列表
    @Test
    public void testFindUserByUserName() throws Exception {
        // 1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2.创建SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 将初始化好的工厂注入到实现类中
        TestUserDao userdao = new TestUserDaoImpl(factory);
        List<TestUser> list = userdao.findUserByUserName("b");
        list.forEach(System.out::println);
    }

    //添加用户
    @Test
    public void testInsertUser() throws IOException {
        // 1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2.创建SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 将初始化好的工厂注入到实现类中
        TestUserDao userdao = new TestUserDaoImpl(factory);
        TestUser user = TestUser.builder()
                .id(10002)
                .account("123456")
                .name("小白")
                .password("12343242")
                .build();
        int i = userdao.insertUser(user);
        System.out.println("插入id:" + user.getId());
    }

    //更新用户
    @Test
    public void testUpdateUserById() throws IOException {
        // 1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2.创建SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 将初始化好的工厂注入到实现类中
        TestUserDao userdao = new TestUserDaoImpl(factory);
        TestUser user = TestUser.builder()
                .id(100202)
                .account("123456")
                .name("小白")
                .password("12343242")
                .build();
        userdao.updateUserById(user);
        System.out.println(user.getId());
    }

    //删除用户
    @Test
    public void testDeleteUserById() throws IOException {
        // 1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2.创建SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 将初始化好的工厂注入到实现类中
        TestUserDao userdao = new TestUserDaoImpl(factory);
        userdao.deleteUserById(34);
    }
}
