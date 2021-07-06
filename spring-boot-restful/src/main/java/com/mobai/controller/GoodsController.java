package com.mobai.controller;

import com.mobai.pojo.GoodsDo;
import com.mobai.service.GoodsService;
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
 * Date: 2021/7/6 14:17
 * ClassName:GoodsController
 * 类描述： 商品控制器
 * 1.@RestController 通过该注解，第一是将GoodsController注册为控制器，可以响应Http请求；第二是可以将控制器中的方法返回值序列化为json格式。
 */
@RestController
public class GoodsController {

    // 自动装配goodsService
    @Autowired
    private GoodsService goodsService;

    /**
     * 查询商品信息
     * 1、@GetMapping表示可以使用get方法请求该api
     * 2、"/goods/{id}"表示请求路径为/goods/{id}的形式，其中{id}为占位符
     * 3、@PathVariable("id")表示将占位符{id}的值传递给id
     * 4、也就是说/goods/123请求的话，会将123传递给参数id
     * 5、请求地址：http://localhost:8080/goods/1
     */
    @GetMapping("/goods/{id}")
    public GoodsDo getOne(@PathVariable("id") long id) {
        return goodsService.getGoodsById(id);
    }

    /**
     * 查询商品列表，使用get方法
     * 请求地址：http://localhost:8080/goods
     */
    @GetMapping("/goods")
    public List<GoodsDo> getList() {
        return goodsService.getGoodsList();
    }

    /**
     * 新增商品
     * 1、@PostMapping表示使用post方法
     * 2、@RequestBody表示将请求中的json信息转换为GoodsDo类型的对象信息，该转换也是由SpringMVC自动完成的
     */
    @PostMapping("/goods")
    public void add(@RequestBody GoodsDo goods) {
        goodsService.addGoods(goods);
    }

    /**
     * 修改商品
     */
    @PutMapping("/goods/{id}")
    public void update(@PathVariable("id") long id, @RequestBody GoodsDo goods) {
        // 修改指定id的商品信息
        goods.setId(id);
        goodsService.editGoods(goods);
    }

    /**
     * 删除商品
     */
    @DeleteMapping("/goods/{id}")
    public void delete(@PathVariable("id") long id) {
        goodsService.removeGoods(id);
    }
}
