package com.mobaijun.pojo;

import lombok.Builder;
import lombok.ToString;

/**
 * Software：IntelliJ IDEA 2021.2 x64
 * Author: https://www.mobaijun.com
 * Date: 2022/1/7 9:46
 * ClassName:User
 * 类描述：
 */
@ToString
@Builder(toBuilder = true)
public class User {
    private String name;
    private String code;
}
