package com.mobaijun.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Software：IntelliJ IDEA 2021.1.1 x64
 * Author: https://www.mobaijun.com
 * Date: 2021/8/2 11:07
 * ClassName:AsyncConfig
 * 类描述：异步配置类
 */
@Configuration
@EnableAsync
public class TaskExecutorConfig implements AsyncConfigurer {


    /**
     *
     */
    private static final int CORE_POOL_SIZE = 5;

    /**
     *
     */
    private static final int MAX_POOL_SIZE = 20;

    /**
     *
     */
    private static final int QUEUE_CAPACITY = 10;

}
