package com.mobaijun.test;

import com.mobaijun.dao.UserDao;
import com.mobaijun.entity.User;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.io.InputStream;
import java.util.List;

/**
 * Software：IntelliJ IDEA 2021.2 x64
 * Author: https://www.mobaijun.com
 * Date: 2022/1/7 17:02
 * ClassName:MybatisTest
 * 类描述：
 */
@Slf4j
@SpringBootTest
public class MybatisTest {

    /**
     * 根据id查询
     */
    @SneakyThrows
    @Test
    public void findById() {
        // 1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2.创建SqlSessionFactory工厂
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(in);
        // 3.使用工厂生产SqlSession对象
        SqlSession session = build.openSession();
        // 4.执行Sql语句
        UserDao userDao = session.getMapper(UserDao.class);
        log.info("代理对象：" + userDao.getClass());
        // 5. 打印结果
        List<User> list = userDao.findByid(1);
        // 输出结果：User(id=1, account=mobai, name=墨白, password=123456)
        list.forEach(System.out::println);
        // 6.释放资源
        session.close();
        in.close();
    }

    /**
     * 删除
     */
    @SneakyThrows
    @Test
    public void deleteById() {
        // 1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2.创建SqlSessionFactory工厂
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(in);
        // 3.使用工厂生产SqlSession对象
        SqlSession session = build.openSession();
        // 4.执行Sql语句
        UserDao userDao = session.getMapper(UserDao.class);
        log.info("代理对象：" + userDao.getClass());
        // 5. 执行SQL
        userDao.deleteById(1);
        // 6.释放资源
        session.close();
        in.close();
    }

    /**
     * 新增
     */
    @SneakyThrows
    @Test
    @Rollback
    public void saveUser() {
        // 1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2.创建SqlSessionFactory工厂
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(in);
        // 3.使用工厂生产SqlSession对象
        SqlSession session = build.openSession();
        // 4.执行Sql语句
        UserDao userDao = session.getMapper(UserDao.class);
        User user;
        for (int i = 0; i < 100; i++) {
            user = User.builder()
                    .id(i + 1)
                    .account("mobai123")
                    .name("mobaijun")
                    .password("123456")
                    .build();
            log.info("代理对象：" + userDao.getClass());
            // 5. 执行SQL
            userDao.saveUser(user);
            // 6. 提交数据
            session.commit();
            System.out.println(user);
        }
        // 7.释放资源
        session.close();
        in.close();
    }

    /**
     * 根据id查询
     */
    @SneakyThrows
    @Test
    public void findAll() {
        // 1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2.创建SqlSessionFactory工厂
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(in);
        // 3.使用工厂生产SqlSession对象
        SqlSession session = build.openSession();
        // 4.执行Sql语句
        UserDao userDao = session.getMapper(UserDao.class);
        log.info("代理对象：" + userDao.getClass());
        // 5. 打印结果
        List<User> list = userDao.findAll();
        list.forEach(System.out::println);
        // 6.释放资源
        session.close();
        in.close();
    }
}
