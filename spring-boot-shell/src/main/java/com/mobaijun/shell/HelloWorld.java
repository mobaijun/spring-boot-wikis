package com.mobaijun.shell;

import com.mobaijun.common.util.PrintUtils;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.LinkedList;
import java.util.List;

/**
 * Software：IntelliJ IDEA 2021.3.2
 * ClassName: HelloWorld
 * 类描述： demo
 *
 * @author MoBaiJun 2022/5/7 14:10
 */
@ShellComponent
public class HelloWorld {

    @ShellMethod("Say hello")
    public void hello(String name) {
        System.out.println("hello, " + name + "!");
    }

    @ShellMethod("Say hello")
    public void word(){
        List<String> list = new LinkedList<>();
        list.add("墨白");
        list.add("小白");
        list.add("李白");
        list.add("白天");
        list.add("白菜");
        list.add("白白");
        list.add("白色");
        PrintUtils.println(list);
    }
}
