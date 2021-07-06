package com.mobai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StringUtils;

@SpringBootApplication
public class SpringBootRestfulApplication {
    public static void main(String[] args) {
        String str = "";
        System.out.println("StringUtils.isEmpty(str) = " + StringUtils.isEmpty(str));
        SpringApplication.run(SpringBootRestfulApplication.class, args);
    }

}
