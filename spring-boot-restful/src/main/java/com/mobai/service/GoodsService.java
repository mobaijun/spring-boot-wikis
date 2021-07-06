package com.mobai.service;

import com.mobai.pojo.GoodsDo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Software：IntelliJ IDEA 2021.1.1 x64
 * Author: https://www.mobaijun.com
 * Date: 2021/7/6 14:14
 * ClassName:GoodsService
 * 类描述： 商品服务实现类
 * 1.服务层方法，建议不要使用 select /insert/update /delete 命名，因为服务层处理的逻辑往往不止于关系数据库表的增删改查。
 * 此处采用的是 get /add/edit /remove 。
 */
@Service
public class GoodsService {
    /**
     * 获取商品列表
     */
    public List<GoodsDo> getGoodsList() {
        List<GoodsDo> goodsList = new ArrayList<GoodsDo>();
        GoodsDo goods = new GoodsDo();
        goods.setId(1L);
        goods.setName("苹果");
        goods.setPic("apple.jpg");
        goods.setPrice("3.5");
        goodsList.add(goods);
        return goodsList;
    }

    /**
     * 按id获取商品信息，模拟返回对应商品信息
     */
    public GoodsDo getGoodsById(Long id) {
        GoodsDo goods = new GoodsDo();
        goods.setId(1L);
        goods.setName("苹果");
        goods.setPic("apple.jpg");
        goods.setPrice("3.5");
        return goods;
    }

    /**
     * 新增商品，模拟返回数据库影响行数
     */
    public int addGoods(GoodsDo goods) {
        return 1;
    }

    /**
     * 根据商品id更新商品信息，模拟返回数据库影响行数
     */
    public int editGoods(GoodsDo goods) {
        return 1;
    }

    /**
     * 根据商品id删除对应商品，模拟返回数据库影响行数
     */
    public int removeGoods(Long id) {
        return 1;
    }
}
