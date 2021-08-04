package com.mobaijun;

<<<<<<< HEAD
=======
import lombok.extern.slf4j.Slf4j;
>>>>>>> 94e936be76fa381ad11eb3d8c28db9b1641efbe4
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 */
@Slf4j
@SpringBootApplication
public class SpringBootThreadApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootThreadApplication.class, args);
        log.info("============================启动完成============================");
    }

}
