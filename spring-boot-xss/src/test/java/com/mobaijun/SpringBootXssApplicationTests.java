package com.mobaijun;

import com.mobaijun.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootXssApplicationTests {

    @Test
    void contextLoads() {
        User mobai = User.builder()
                .name("mobai")
                .code("100010")
                .build();
        mobai = mobai.toBuilder().name("mobaiss").code("1239872321").build();
        System.out.println("mobai = " + mobai);
    }
}
