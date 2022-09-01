package com.mobaijun.strategymode;

import org.springframework.stereotype.Component;

/**
 * Software：IntelliJ IDEA 2021.2 x64
 * Author: <a href="https://www.mobaijun.com">...</a>
 * Date: 2021/11/11 15:40
 * ClassName:ZhangSanHandler
 * 类描述： 具体算法类
 */
@Component
public class ZhangSanHandler implements Handler {
    @Override
    public void AAA(String name) {
        // 业务逻辑
        System.out.println("亢八完成任务");
    }

    @Override
    public void afterPropertiesSet() {
        Factory.register("张三", this);
    }
}
