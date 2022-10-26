package com.mobai.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Software：IntelliJ IDEA 2021.1.1 x64
 * Author: <a href="https://www.mobaijun.com">...</a>
 * Date: 2021/7/5 16:43
 * ClassName:GoodsDo
 * 类描述： 商品信息实体类
 */
@Getter
@Setter
@ToString
public class GoodsDo {
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
