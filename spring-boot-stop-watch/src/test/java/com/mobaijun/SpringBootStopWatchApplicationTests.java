package com.mobaijun;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

@Slf4j
@SpringBootTest
class SpringBootStopWatchApplicationTests {

    @Test
    void test1() throws InterruptedException {
        StopWatch sw = new StopWatch();
        sw.start();
        Thread.sleep(10000);
        sw.stop();
        System.out.println("sw = " + sw.getTotalTimeMillis());
    }

    @Test
    void test2() throws InterruptedException {
        StopWatch sw = new StopWatch();
        sw.start("A");
        Thread.sleep(10000);
        sw.stop();
        System.out.println("sw = " + sw.getLastTaskTimeMillis());
    }

    @Test
    void test3() throws InterruptedException {
        StopWatch sw = new StopWatch();
        sw.start("A");
        Thread.sleep(500);
        sw.stop();
        sw.start("B");
        Thread.sleep(300);
        sw.stop();
        sw.start("C");
        Thread.sleep(200);
        sw.stop();
        System.out.println("sw = " + sw.prettyPrint());
    }
}
