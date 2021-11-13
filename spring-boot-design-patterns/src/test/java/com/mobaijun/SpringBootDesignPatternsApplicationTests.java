package com.mobaijun;

import com.mobaijun.strategymode.Factory;
import com.mobaijun.strategymode.Handler;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootDesignPatternsApplicationTests {

    @Test
    void contextLoads() {
        String name = "张三";
        Handler invokeStrategy = Factory.getInvokeStrategy(name);
        invokeStrategy.AAA(name);
    }

}
