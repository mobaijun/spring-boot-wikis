package com.mobaijun.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

/**
 * Software：IntelliJ IDEA 2021.2 x64
 * Author: https://www.mobaijun.com
 * Date: 2022/1/10 17:07
 * ClassName:TranslationCommands
 * 类描述： 基础测试类
 */
@ShellComponent
public class TranslationCommands {


    @ShellMethod(value = "输入两个整数，获取相加结果")
    public int add(int a, int b) {
        return a + b;
    }

}
