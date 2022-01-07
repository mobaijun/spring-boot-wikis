package com.mobaijun.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

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
     * 1.配置类实现AsyncConfigurer接口并重写getAsyncExcutor方法，并返回一个ThreadPoolTaskExevutor
     * 2.通过重写getAsyncExecutor方法，制定默认的任务执行由该方法产生
     * 3.这样我们就获得了一个基于线程池的TaskExecutor
     */

    /**
     * 设置ThreadPoolExecutor的核心池大小。
     */
    private static final int CORE_POOL_SIZE = 5;

    /**
     * 设置ThreadPoolExecutor的最大池大小。
     */
    private static final int MAX_POOL_SIZE = 20;

    /**
     * 设置ThreadPoolExecutor的BlockingQueue的容量。
     */
    private static final int QUEUE_CAPACITY = 10;
    /**
     * 线程前缀名称
     */
    private static final String THREAD_NAME_PREFIX = "thread-exec-";

    /**
     * 默认线程池配置执行器
     */
    @Override
    @Bean
    public Executor getAsyncExecutor() {
        // 1.Spring 默认配置是核心线程数大小为1，最大线程容量大小不受限制，队列容量也不受限制。
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        // 2.核心线程数
        taskExecutor.setCorePoolSize(CORE_POOL_SIZE);
        // 3.最大线程数
        taskExecutor.setMaxPoolSize(MAX_POOL_SIZE);
        // 4.队列大小
        taskExecutor.setQueueCapacity(QUEUE_CAPACITY);
        // 5.线程前缀名称
        taskExecutor.setThreadNamePrefix(THREAD_NAME_PREFIX);
        // 6.当最大池已满时，此策略保证不会丢失任务请求，但是可能会影响应用程序整体性能。
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 7.初始化线程池
        taskExecutor.initialize();
        return taskExecutor;
    }


    /**
     * 自定义任务执行器：在定义了多个任务执行器的情况下，可以使用@Async("getMineAsync")来设定
     */
    @Bean
    public Executor getMineAsync() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(CORE_POOL_SIZE - 4);
        executor.setMaxPoolSize(MAX_POOL_SIZE - 10);
        executor.setQueueCapacity(QUEUE_CAPACITY - 5);
        executor.setThreadNamePrefix(THREAD_NAME_PREFIX);
        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }
}
