package com.mobaijun.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Software：IntelliJ IDEA 2021.3.2
 * ClassName: com.mobaijun.jpa.model.SpringBootJpaTest
 * 类描述：
 * <p>
 * \@Entity告诉JPA这是一个实体类
 * \@Table 指定这个实体类对应哪个表，如果不写名字的话就自动生成或对应类名全小写
 * \@Id 主键
 * \@GeneratedValue(strategy = GenerationType.IDENTITY)   定义主键自增类型 strategy: 表示主键生成策略 , 有 AUTO,INDENTITY,SEQUENCE 和 TABLE 4 种 ,
 * \@Column(name = "lastname")  指定该属性对应表中哪个字段
 * </p>
 * @author MoBaiJun 2022/5/10 14:22
 */
@SpringBootApplication
public class SpringBootJpaTest {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJpaTest.class, args);
    }
}
