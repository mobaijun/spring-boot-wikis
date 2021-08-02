package com.mobaijun.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.concurrent.Future;

/**
 * Software：IntelliJ IDEA 2021.1.1 x64
 * Author: https://www.mobaijun.com
 * Date: 2021/8/2 17:00
 * ClassName:ArithmeticService
 * 类描述：操作计算 service 类：简单实现有关异步和同步两种计算方式的性能比较
 */
@Slf4j
@Component
public class ArithmeticService implements Serializable {

    /**
     * 休眠时间
     */
    public static final int DoTime = 5000;

    /**
     * 1.异步任务只需要在所需实现异步的方法上加上@Async注解， 并通过Future<E>来接受异步方法的处理结果
     * 2.通过@Async注解表明该方法是个异步方法，如果注解在类级别，则表明该类所有的方法都是异步方法
     */
    @Async
    public Future<Long> subByAsync() throws Exception {
        long start = System.currentTimeMillis();
        long sum = 0;
        Thread.sleep(DoTime);
        long end = System.currentTimeMillis();
        sum = end - start;
        log.info("\t 完成任务一");
        return new AsyncResult<>(sum);
    }

    /**
     * 仅使用异步注解的方式实现异步方法
     */
    @Async
    public void subByVoid() throws Exception {
        long start = System.currentTimeMillis();
        long sum = 0;
        Thread.sleep(DoTime);
        long end = System.currentTimeMillis();
        sum = end - start;
        log.info("\t 完成任务二   ");
        log.info("注解任务执行的时间是： " + sum + "（毫秒）");
    }

    /**
     * 使用同步计算的方式--同步调用
     */
    public long subBySync() throws Exception {
        long start = System.currentTimeMillis();
        long sum = 0;
        Thread.sleep(DoTime);
        long end = System.currentTimeMillis();
        sum = end - start;
        log.info("\t 完成任务三   ");
        return sum;
    }

    @Async("getMineAsync")
    public void doMineAsync(int i) throws Exception {
        System.out.println("------\t:" + i);
        Thread.sleep(10000);
    }
}
