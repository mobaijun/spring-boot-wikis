package com.mobaijun.service;


import com.mobaijun.dao.GoodsDao;
import com.mobaijun.domain.GoodsDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Software：IntelliJ IDEA 2021.1.1 x64
 * Author: <a href="https://www.mobaijun.com">...</a>
 * Date: 2021/7/6 16:17
 * ClassName:GoodsService
 * 类描述：
 */
@Service
public class GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    /**
     * 新增商品
     */
    public void add(GoodsDo goods) {
        goodsDao.insert(goods);
    }

    /**
     * 删除商品
     */
    public void remove(Long id) {
        goodsDao.delete(id);
    }

    /**
     * 编辑商品信息
     */
    public void edit(GoodsDo goods) {
        goodsDao.update(goods);
    }

    /**
     * 按id获取商品信息
     */
    public GoodsDo getById(Long id) {
        return goodsDao.getById(id);
    }

    /**
     * 获取商品信息列表
     */
    public List<GoodsDo> getList() {
        return goodsDao.getList();
    }
}
