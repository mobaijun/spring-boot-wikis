package com.mobaijun.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Software：IntelliJ IDEA 2021.1.1 x64
 * Author: <a href="https://www.mobaijun.com">...</a>
 * Date: 2021/7/7 14:25
 * ClassName:CorsConfig
 * 类描述： 跨域配置类
 */
@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsWebMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // 添加映射路径
                registry.addMapping("/**")
                        // 放行哪些原始域
                        .allowedOriginPatterns("*")
                        // 是否发送Cookie信息
                        .allowCredentials(true)
                        // 放行哪些原始域(请求方式)
                        .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS", "PATCH")
                        // 放行哪些原始域(头部信息)
                        .allowedHeaders("*")
                        // 暴露哪些头部信息（因为跨域访问默认不能获取全部头部信息）
                        .exposedHeaders("Header1", "Header2")
                        // 预请求的结果有效期，默认1800分钟,3600是一小时
                        .maxAge(3600);
            }
        };
    }
}
