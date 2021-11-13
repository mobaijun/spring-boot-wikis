package com.mobaijun.strategymode;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Software：IntelliJ IDEA 2021.2 x64
 * Author: https://www.mobaijun.com
 * Date: 2021/11/11 15:36
 * ClassName:Factory
 * 类描述： 工厂设计模式
 */
public class Factory {

    private static Map<String, Handler> stringHandlerMap = new HashMap<>();

    public static Handler getInvokeStrategy(String name) {
        return stringHandlerMap.get(name);
    }

    public static void register(String name, Handler handler) {
        if (StringUtils.isEmpty(name) || null == handler) {
            return;
        }
        stringHandlerMap.put(name, handler);
    }
}
