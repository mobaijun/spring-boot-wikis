package com.mobaijun.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Software：IntelliJ IDEA 2021.2 x64
 * Author: https://www.mobaijun.com
 * Date: 2022/1/10 9:54
 * ClassName:TestUser
 * 类描述： 用户实体
 */
@ToString
@Getter
@Setter
@Builder
public class TestUser {
    Integer id;
    String account;
    String name;
    String password;
}
