package com.mobai.controller;

import com.mobai.pojo.GoodsDo;
import com.mobai.service.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Software：IntelliJ IDEA 2021.1.1 x64
 * Author: https://www.mobaijun.com
 * Date: 2021/7/6 16:17
 * ClassName:GoodsController
 * 类描述：
 */
@RestController
@RequiredArgsConstructor
public class GoodsController {

    private final GoodsService goodsService;

    /**
     * 遵循Restful规范的接口
     * 请求地址：<a href="http://127.0.0.1:8080/goods">...</a>
     */
    @GetMapping("/goods")
    public List<GoodsDo> getList() {
        return goodsService.getGoodsList();
    }
}
