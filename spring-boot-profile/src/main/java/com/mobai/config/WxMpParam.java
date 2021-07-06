package com.mobai.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Software：IntelliJ IDEA 2021.1.1 x64
 * Author: https://www.mobaijun.com
 * Date: 2021/7/6 15:39
 * ClassName:WxMpParam
 * 类描述： 自定义组件
 */
@Data
@Component
// 启用配置自动注入功能
@EnableConfigurationProperties
// 指定类对应的配置项前缀
// @ConfigurationProperties(prefix = "wxmp")
// 指定配置文件及编码
@PropertySource(value = "classpath:application-wxmp.yml", encoding = "utf-8")
public class WxMpParam {

    // 注入wxmp.appid配置项
    @Value("${wxmp.appid}")
    private String appid;

    // 注入wxmp.secret配置项
    @Value("${wxmp.secret}")
    private String secret;

    /**
     * 如果参数很多，一一指定对象属性和配置项的关联非常麻烦。
     * 可以通过设定对象与配置项的对应关系，来实现配置项的自动注入。
     */
    // 对应到wxmp.appid
    // private String appid;
    // 对应到wxmp.secret
    // private String secret;
    /**
     * 在上面的代码中，通过 prefix = "wxmp" 指定了关联配置的前缀，属性 appid 即关联到前缀 + 属性名为 wxmp.appid 的配置项。
     * 同理，属性 secret 关联到 wxmp.secret 配置项。
     */
}
