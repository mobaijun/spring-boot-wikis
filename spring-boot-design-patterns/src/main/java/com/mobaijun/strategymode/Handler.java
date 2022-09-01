package com.mobaijun.strategymode;

import org.springframework.beans.factory.InitializingBean;

/**
 * Software：IntelliJ IDEA 2021.2 x64
 * Author: <a href="https://www.mobaijun.com">...</a>
 * Date: 2021/11/11 15:32
 * InterfaceName:Handler
 * 接口描述： 策略模式总接口，并继承初始化Bean这个类
 */
public interface Handler extends InitializingBean {

    /**
     * if else 算法逻辑
     */
    public void AAA(String name);
}
