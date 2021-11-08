package com.mobaijun.dao;

import com.mobaijun.domain.GoodsDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Software：IntelliJ IDEA 2021.1.1 x64
 * Author: https://www.mobaijun.com
 * Date: 2021/7/7 14:13
 * ClassName:GoodsDao
 * 类描述： 数据访问接口
 */
// 标注数据访问类
@Repository
public class GoodsDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    /**
     * 新增
     */
    public void insert(GoodsDo goodsDo) {
        jdbcTemplate.update("insert into goods(name,price,pic)values(?,?,?)"
                , goodsDo.getName(), goodsDo.getPrice(), goodsDo.getPic());
    }

    /**
     * 删除
     */
    public void delete(Long id) {
        jdbcTemplate.update("delete from goods where id = ?", id);
    }

    /**
     * 更新
     */
    public void update(GoodsDo goodsDo) {
        jdbcTemplate.update("update goods set name=? ,price=?,pic=? where id=?"
                , goodsDo.getName(), goodsDo.getPrice(), goodsDo.getPic(), goodsDo.getId());
    }

    /**
     * 按id查询
     */
    public GoodsDo getById(Long id) {
        return jdbcTemplate.queryForObject("select * from goods where id=?", new RowMapper<GoodsDo>() {
            @Override
            public GoodsDo mapRow(ResultSet rs, int rowNum) throws SQLException {
                GoodsDo goods = new GoodsDo();
                goods.setId(rs.getLong("id"));
                goods.setName(rs.getString("name"));
                goods.setPrice(rs.getString("price"));
                goods.setPic(rs.getString("pic"));
                return goods;
            }
        }, id);
    }

    /**
     * 查询商品列表
     */
    public List<GoodsDo> getList() {
        return jdbcTemplate.query("select * from goods", new RowMapper<GoodsDo>() {
            @Override
            public GoodsDo mapRow(ResultSet rs, int rowNum) throws SQLException {
                GoodsDo goods = new GoodsDo();
                goods.setId(rs.getLong("id"));
                goods.setName(rs.getString("name"));
                goods.setPrice(rs.getString("price"));
                goods.setPic(rs.getString("pic"));
                return goods;
            }
        });
    }
}
