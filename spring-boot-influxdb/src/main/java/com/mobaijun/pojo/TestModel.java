package com.mobaijun.pojo;

import lombok.Data;
import org.influxdb.annotation.Column;

/**
 * Software：IntelliJ IDEA 2021.2 x64
 * Author: <a href="https://www.mobaijun.com">...</a>
 * Date: 2021/11/22 11:01
 * ClassName:TestModel
 * 类描述： 测试实体类
 */
@Data
// @Measurement(name = "TEST")
public class TestModel {

    /**
     * 表名
     */
    private String tableName;

    @Column(name = "name")
    private String name;

    @Column(name = "time")
    private String time;

    @Column(name = "host")
    private String host;

    @Column(name = "port")
    private String port;

    @Column(name = "menuId")
    private String menuId;

    @Column(name = "value")
    private String value;

    @Column(name = "value_type")
    private String valueType;
}
