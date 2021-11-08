package com.mobaijun.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * Software：IntelliJ IDEA 2021.2 x64
 * Author: https://www.mobaijun.com
 * Date: 2021/10/21 15:05
 * ClassName:User
 * 类描述： 用户类
 */
@Data
public class User implements Serializable {
    // 用户id
    private Long id;
    // 用户名
    private String userName;
    // 性别
    private String userSex;
}
