package com.mobaijun.service;

import com.mobaijun.pojo.TestModel;

import java.util.List;

/**
 * Software：IntelliJ IDEA 2021.2 x64
 * Author: <a href="https://www.mobaijun.com">...</a>
 * Date: 2021/11/22 11:14
 * InterfaceName:influxdbService
 * 接口描述： 测试接口
 */
public interface InfluxdbService {

    /**
     * 插入测试数据
     */
    void insertTest(TestModel testModel);

    /**
     * 查询数据
     */
    List<TestModel> getAllList(StringBuilder sql);

    /**
     * 删除数据库
     */
    void deleteDbName(String dbName);
}
