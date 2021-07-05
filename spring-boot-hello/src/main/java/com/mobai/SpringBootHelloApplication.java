package com.mobai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 学习教程地址：http://www.imooc.com/wiki/springbootlesson/started.html
 * 等等，好像还有一个注解 @SpringBootApplication ，该注解是标注在类上的，属于类的信息。嗯，看来 Spring Boot 启动的秘密就在这个注解上了。
 * 拥有了 @SpringBootConfiguration ，我们就拥有了一个可以拿来即用的 Spring 容器环境了。
 */
@SpringBootApplication
public class SpringBootHelloApplication {

    // 我们来分析下这段代码， public static void main 是普通的 main 方法，是程序执行的入口。
    public static void main(String[] args) {
        // SpringApplication.run 看字面意思就知道，这是 Spring 应用的启动方法，运行该行代码后， javax.swing.Spring 应用就跑起来了。
        // 这个方法有两个参数， args 是命令行参数，此处没啥作用；另一个参数是 SpringBootHelloApplication.class ，包含类的信息。
        SpringApplication.run(SpringBootHelloApplication.class, args);
    }

    /**
     * @SpringBootConfiguration
     * 1.首先是 @SpringBootConfiguration 注解，它继承自 @Configuration 注解，功能也跟 @Configuration 一样。
     * 它会将当前类标注为配置类了，我们在启动类中配置 Bean 就可以生效了。
     * @EnableAutoConfiguration
     * 2. 最重要的是 @EnableAutoConfiguration 注解，用来启动自动配置。
     * 开启自动配置后， Spring Boot 会扫描项目中所有的配置类，然后根据配置信息启动 Spring 容器。
     * @ComponentScan(excludeFilters = { @Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class),
     * @Filter(type = FilterType.CUSTOM, classes = AutoConfigurationExcludeFilter.class) })
     * 3. 其次是 @ComponentScan 注解，用来指定我们要扫描的包，以便发现 Bean 。
     * 注意在默认情况下， SpringBoot 扫描该注解标注类所在包及其子包。
     * 当我们的控制器、服务类等 Bean 放到不同的包中时，就需要通过 @ComponentScan 注解指定这些包，以便发现 Bean 。
     */
}
