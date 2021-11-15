package com.mobaijun;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Software：IntelliJ IDEA 2021.2 x64
 * Author: https://www.mobaijun.com
 * Date: 2021/11/15 13:43
 * ClassName:User
 * 类描述： 实体类
 */
@Data
@NoArgsConstructor
public class User {
    private Long id;
    private String name;
    private Integer age;
}
