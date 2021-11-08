package com.mobaijun.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Software：IntelliJ IDEA 2021.1.1 x64
 * Author: https://www.mobaijun.com
 * Date: 2021/7/6 14:49
 * ClassName:SwaggerProperties
 * 类描述： swagger配置类
 * 1. @Component 是一个通用的构造型注解，表明该类是一个 spring 组件
 * 2. @ConfigurationProperties("swagger")
 */
@Data
@Component
@ConfigurationProperties("swagger")
public class SwaggerProperties {
    /**
     * 是否开启swagger，生产环境一般关闭，所以这里定义一个变量
     */
    private Boolean enable;

    /**
     * 项目应用名
     */
    private String applicationName;

    /**
     * 项目版本信息
     */
    private String applicationVersion;

    /**
     * 项目描述信息
     */
    private String applicationDescription;

    /**
     * 接口调试地址
     */
    private String tryHost;
}
