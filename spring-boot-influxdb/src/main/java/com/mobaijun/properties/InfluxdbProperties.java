package com.mobaijun.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Software：IntelliJ IDEA 2021.2 x64
 * Author: <a href="https://www.mobaijun.com">...</a>
 * Date: 2021/11/22 10:01
 * ClassName:InfluxdbProperties
 * 类描述： influxdb属性映射配置类
 */
@Data
@Component
@ConfigurationProperties(InfluxdbProperties.PREFIX)
@EnableConfigurationProperties(InfluxdbProperties.class)
public class InfluxdbProperties {

    /**
     * 隐射配置文件路径
     */
    public static final String PREFIX = "spring.influx";

    /**
     * 链接地址
     */
    private String url;

    /**
     * 用户名
     */
    private String user;

    /**
     * 密码
     */
    private String password;

    /**
     * 数据库
     */
    private String database;

    /**
     * 存储策略
     */
    private String retentionPolicy;

    /**
     * 数据过期时间
     */
    private String retentionPolicyTime;
}
