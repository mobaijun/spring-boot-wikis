package com.mobaijun.strategymode;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Software：IntelliJ IDEA 2021.2 x64
 * Author: <a href="https://www.mobaijun.com">...</a>
 * Date: 2021/11/11 15:36
 * ClassName:Factory
 * 类描述： 工厂设计模式
 */
public class Factory {

    private static final Map<String, Handler> STRING_HANDLER_MAP = new HashMap<>();

    public static Handler getInvokeStrategy(String name) {
        return STRING_HANDLER_MAP.get(name);
    }

    public static void register(String name, Handler handler) {
        if (StringUtils.isEmpty(name) || null == handler) {
            return;
        }
        STRING_HANDLER_MAP.put(name, handler);
    }
}
