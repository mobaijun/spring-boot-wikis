package com.mobai.controller;

import com.mobai.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Software：IntelliJ IDEA 2021.1.1 x64
 * Author: https://www.mobaijun.com
 * 类描述：商品控制器
 * 1. @Controller 注解标注在 GoodsController 类上，会为该类注册一个控制器组件，放入 Spring 容器中。该组件具备处理请求的能力，其中的方法可以响应 HTTP 请求；
 * 2. @RequestMapping ("/goods") 注解标注在方法 goods () 上，所以请求路径如果匹配 /goods ，则由该方法进行处理；
 * 3. 返回值是字符串 "goods" ，由于我们已经引入 FreeMarker 依赖，所以该返回值会跳转到 goods.ftl 页面。
 */
@Controller
public class GoodsController {

    @Autowired
    // 自动装配
    private GoodsService goodsService;

    /**
     * 获取商品列表
     * /goods:请求路径
     * 访问地址：http://127.0.0.1:8080/goods
     */
    @RequestMapping("/goods")
    public String goods(Model model) {
        // 交给模板引擎处理的数据
        model.addAttribute("goodsList", goodsService.getGoodsList());
        // 跳转到goods.ftl页面
        return "goods.html";
    }
}
