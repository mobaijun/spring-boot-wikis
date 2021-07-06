package com.mobai.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Software：IntelliJ IDEA 2021.1.1 x64
 * Author: https://www.mobaijun.com
 * Date: 2021/7/6 14:13
 * ClassName:GoodsDo
 * 类描述： 商品实体类
 */
@Data
@Getter
@Setter
@ToString
public class GoodsDo {
    /**
     * 商品id
     */
    private Long id;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 商品价格
     */
    private String price;
    /**
     * 商品图片
     */
    private String pic;
}
