package com.mobaijun.config;

import com.mobaijun.properties.InfluxdbProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Software：IntelliJ IDEA 2021.2 x64
 * Author: https://www.mobaijun.com
 * Date: 2021/11/22 10:19
 * ClassName:influxdbConfig
 * 类描述： influxdb配置类
 */
@Configuration
public class influxdbConfig {

    /**
     * 初始化属性
     */
    @Bean
    @ConditionalOnMissingBean
    public InfluxdbProperties getInfluxdbProperties() {
        return new InfluxdbProperties();
    }

    /**
     * 初始化influxdb
     */
    @Bean
    public InfluxDbConnection getInfluxdb(InfluxdbProperties influxdbProperties) {
        return new InfluxDbConnection(
                influxdbProperties.getUser(),
                influxdbProperties.getPassword(),
                influxdbProperties.getUrl(),
                influxdbProperties.getDatabase(),
                influxdbProperties.getRetentionPolicy(),
                influxdbProperties.getRetentionPolicyTime());
    }
}
