package com.mobaijun;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;

@SpringBootTest
class SpringBootRedisApplicationTests {

    @Resource(name = "redisTemplate1")
    private StringRedisTemplate redisTemplate1;
    @Resource(name = "redisTemplate2")
    private StringRedisTemplate redisTemplate2;

    @Test
    void contextLoads() {
        redisTemplate1.opsForValue().set("keyName", "mobaijun");
        System.out.println(redisTemplate1.opsForValue().get("keyName"));
    }

    @Test
    void setRedisTemplate2() {
        redisTemplate2.opsForValue().set("name", "mobaijun");
        System.out.println(redisTemplate2.opsForValue().get("name"));
    }
}
