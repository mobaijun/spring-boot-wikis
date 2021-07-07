package com.mobai.service;

import com.mobai.pojo.GoodsDo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Software：IntelliJ IDEA 2021.1.1 x64
 * Author: https://www.mobaijun.com
 * Date: 2021/7/6 16:17
 * ClassName:GoodsService
 * 类描述：
 */
@Service
public class GoodsService {
    /**
     * 获取商品列表
     */
    public List<GoodsDo> getGoodsList() {
        //模拟从数据库查询出的结果返回
        List<GoodsDo> goodsList = new ArrayList<GoodsDo>();
        GoodsDo goods = new GoodsDo();
        goods.setId(1L);
        goods.setName("苹果");
        goods.setPic("apple.jpg");
        goods.setPrice("3.5");
        goodsList.add(goods);
        return goodsList;
    }
}
