package com.mobaijun.controller;

import com.mobaijun.pojo.GoodsDo;
import com.mobaijun.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    /**
     * 按id获取商品信息
     */
    @GetMapping("/goods/{id}")
    public GoodsDo getOne(@PathVariable("id") long id) {
        return goodsService.getById(id);
    }

    /**
     * 获取商品列表
     */
    @GetMapping("/goods")
    public List<GoodsDo> getList() {
        return goodsService.getList();
    }

    /**
     * 新增商品
     */
    @PostMapping("/goods")
    public void add(@RequestBody GoodsDo goods) {
        goodsService.add(goods);
    }

    /**
     * 编辑商品
     */
    @PutMapping("/goods/{id}")
    public void update(@PathVariable("id") long id, @RequestBody GoodsDo goods) {
        // 修改指定id的博客信息
        goods.setId(id);
        goodsService.edit(goods);
    }

    /**
     * 移除商品
     */
    @DeleteMapping("/goods/{id}")
    public void delete(@PathVariable("id") long id) {
        goodsService.remove(id);
    }
}
