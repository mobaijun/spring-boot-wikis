package com.mobai.service;

import com.mobai.pojo.GoodsDo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Software：IntelliJ IDEA 2021.1.1 x64
 * Author: <a href="https://www.mobaijun.com">...</a>
 * Date: 2021/7/5 16:44
 * ClassName:GoodsService
 * 类描述： 商品信息服务类
 */
@Service
public class GoodsService {

    /**
     * 获取商品列表
     */
    public List<GoodsDo> getGoodsList() {
        ArrayList<GoodsDo> list = new ArrayList<>();
        GoodsDo goods = new GoodsDo();
        goods.setName("苹果");
        goods.setPrice("3.5");
        goods.setPic("MoBai.jpg");
        list.add(goods);
        return list;
    }
}
