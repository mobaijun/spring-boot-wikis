package com.mobaijun.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Software：IntelliJ IDEA 2021.2 x64
 * Author: https://www.mobaijun.com
 * Date: 2022/1/6 10:50
 * ClassName:XssController
 * 类描述：
 */
@Slf4j
@RestController
@RequestMapping("/")
public class XssController {

    /**
     * 模拟参数：<script>alert("xss");</script>
     */
    @GetMapping("/xss")
    public String xss(String data) {
        log.info(data);
        return data;
    }
}
