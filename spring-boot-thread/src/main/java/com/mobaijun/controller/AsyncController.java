package com.mobaijun.controller;

import com.mobaijun.service.ArithmeticService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

/**
 * Software：IntelliJ IDEA 2021.1.1 x64
 * Author: https://www.mobaijun.com
 * Date: 2021/8/2 17:06
 * ClassName:AsyncController
 * 类描述：
 */
@Slf4j
@RestController
public class AsyncController {


    @Autowired
    private ArithmeticService arithmeticService;

    @SuppressWarnings("static-access")
    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public void index() {
        long start = System.currentTimeMillis();
        try {
            log.info("--------------------------------------------\n");
            log.info("每个任务执行的时间是：" + arithmeticService.DoTime + "（毫秒）");

            Future<Long> task = arithmeticService.subByAsync();

            arithmeticService.subByVoid();

            long sync = arithmeticService.subBySync();

            while (true) {
                if (task.isDone()) {
                    long async = task.get();
                    log.info("异步任务执行的时间是：" + async + "（毫秒）");
                    // log.info("注解任务执行的时间是： -- （毫秒）");
                    log.info("同步任务执行的时间是：" + sync + "（毫秒）");
                    break;
                }
            }
            log.info("--------------------------------------------\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        log.info("\t........请求响应时间为：" + (end - start) + "（毫秒）");
    }

    /**
     * 自定义实现线程异步
     */
    @RequestMapping(value = {"/mine", "/m*"}, method = RequestMethod.GET)
    public void mineAsync() {
        for (int i = 0; i < 100; i++) {
            try {
                arithmeticService.doMineAsync(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
