package com.mobai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootProfileApplication {

    /**
     * 1、Tomcat started on port(s): 8080 (http) with context path '' 控制台输出tomcat默认8080端口，应用上下文路径为null
     * 2、我们可以通过修改 resources/application.yml 来自定义项目启动配置:
     * 3、再次启动，控制台输出变为 Tomcat started on port(s): 8002 (http) with context path '/spring-boot-profile'
     * 4、Spring Boot 支持两种格式的配置文件，即 .properties 文件和 .yml 配置文件。
     *  4.1、.properties 配置使用顿号分割语义，而 .yml 配置使用缩进分割语义。这两种配置文件没有本质区别，只是格式不同。
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringBootProfileApplication.class, args);
    }

}
