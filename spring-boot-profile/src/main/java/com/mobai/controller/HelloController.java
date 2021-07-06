package com.mobai.controller;

import com.mobai.config.WxMpParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Software：IntelliJ IDEA 2021.1.1 x64
 * Author: https://www.mobaijun.com
 * Date: 2021/7/6 15:25
 * ClassName:HelloController
 * 类描述： 测试控制器
 * 1、@RestController 标注为控制器，且返回值序列化为json
 */
@RestController
public class HelloController {

    @Autowired
    private WxMpParam wxMpParam;

    /**
     * 响应get请求，匹配的请求路径为/hello
     * 请求路径：http://localhost:8002/spring-boot-profile/hello
     */
    @GetMapping("/hello")
    public Map hello() {
        Map<String, String> map = new HashMap<>();
        map.put("test", "content for test");
        return map;
    }

    /**
     * test类
     * 请求地址：http://localhost:8002/spring-boot-profile/wxtest
     */
    @GetMapping("/wxtest")
    public Map wxtest() {
        Map<String, String> map = new HashMap<>();
        map.put("appid", wxMpParam.getAppid());
        map.put("secret", wxMpParam.getSecret());
        return map;
    }
}
