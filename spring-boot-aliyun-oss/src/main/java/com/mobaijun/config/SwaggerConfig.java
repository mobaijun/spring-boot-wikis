package com.mobaijun.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Software：IntelliJ IDEA 2021.2 x64
 * Author: <a href="https://www.mobaijun.com">...</a>
 * Date: 2021/12/22 10:48
 * ClassName:SwaggerConfig
 * 类描述：
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .select()
                // 过滤的接口
                .apis(RequestHandlerSelectors.basePackage("com.mobaijun"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo getApiInfo() {
        // 定义联系人信息
        Contact contact = new Contact("墨白", "https://www.mobaijun.com", "mobaijun8@163.com");
        return new ApiInfoBuilder()
                // 标题
                .title("集成阿里云oss")
                // 描述信息
                .description("集成阿里云oss")
                // 版本
                .version("1.0.0")
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
                .contact(contact)
                .build();
    }
}
