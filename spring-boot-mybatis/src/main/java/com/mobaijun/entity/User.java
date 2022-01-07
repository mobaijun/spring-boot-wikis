package com.mobaijun.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Software：IntelliJ IDEA 2021.2 x64
 * Author: https://www.mobaijun.com
 * Date: 2022/1/7 15:42
 * ClassName:User
 * 类描述：用户实体
 */
@ToString
@Getter
@Setter
@Builder
public class User {
    Integer id;
    String account;
    String name;
    String password;
}
