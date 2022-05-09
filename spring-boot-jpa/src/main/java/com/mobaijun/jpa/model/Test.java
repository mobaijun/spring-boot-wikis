package com.mobaijun.jpa.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Software：IntelliJ IDEA 2021.3.2
 * ClassName: Test
 * 类描述： 测试类
 * <p>
 * \@Entity告诉JPA这是一个实体类
 * \@Table 指定这个实体类对应哪个表，如果不写名字的话就自动生成或对应类名全小写
 * \@Id 主键
 * \@GeneratedValue(strategy = GenerationType.IDENTITY)   定义主键自增类型 strategy: 表示主键生成策略 , 有 AUTO,INDENTITY,SEQUENCE 和 TABLE 4 种 ,
 * \@Column(name = "lastname")  指定该属性对应表中哪个字段
 * </p>
 *
 * @authorMoBaiJun 2022/5/7 11:41
 */
@Entity
@Table(name = "table")
public class Test extends AbstractPersistable<Long> {

    private Long id;
}
