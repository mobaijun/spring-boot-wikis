package com.mobaijun;

import com.mobaijun.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;

@SpringBootTest
class SpringBootRedisJedisApplicationTests {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private RedisTemplate<String, Serializable> serializableRedisTemplate;

    @Test
    void contextLoads() {
        redisTemplate.opsForValue().set("keyName", "mobaijun");
        System.out.println(redisTemplate.opsForValue().get("keyName"));
    }

    @Test
    public void testSerializable() {
        User user = new User();
        user.setId(1L);
        user.setUserName("墨白君");
        user.setUserSex("男");
        serializableRedisTemplate.opsForValue().set("user", user);
        User user2 = (User) serializableRedisTemplate.opsForValue().get("user");
        System.out.println("user:" + user2.getId() + "," + user2.getUserName() + "," + user2.getUserSex());
    }
}
