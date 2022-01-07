package com.mobaijun.config;

import cn.hutool.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Software：IntelliJ IDEA 2021.2 x64
 * Author: https://www.mobaijun.com
 * Date: 2022/1/7 13:50
 * ClassName:MongoConfig
 * 类描述： mongo配置类
 */
@Component
public class MongoConfig {

    @Resource
    private MongoTemplate mongoTemplate;

    /**
     * 保存数据（可覆盖）
     *
     * @param dataJsonObject 数据JSON对象
     * @param collectionName 指定集合名称
     * @param idColumn       指定ID字段
     */
    public void saveObject(JSONObject dataJsonObject, String collectionName, String idColumn) {
        if (idColumn != null) {
            dataJsonObject.put("_id", dataJsonObject.get(idColumn));
        }
        if (StringUtils.isEmpty(collectionName)) {
            mongoTemplate.save(dataJsonObject);
        } else {
            mongoTemplate.save(dataJsonObject, collectionName);
        }
    }

    /**
     * 获取数据
     *
     * @param collectionName 指定集合名称
     * @param limitNum       获取记录数量
     * @param skipNum        跳过记录数量
     */
    public List<JSONObject> findObject(String collectionName, Integer skipNum, Integer limitNum, Sort sort) {
        Query query = new Query();
        if (sort != null) {
            query.with(sort);
        }
        query.limit(limitNum);
        query.skip(skipNum);
        return mongoTemplate.find(query, JSONObject.class, collectionName);
    }
}
