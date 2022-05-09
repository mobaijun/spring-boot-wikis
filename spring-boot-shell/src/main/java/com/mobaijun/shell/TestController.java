package com.mobaijun.shell;

import com.mobaijun.common.util.page.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

/**
 * Software：IntelliJ IDEA 2021.3.2
 * ClassName: TestController
 * 类描述：
 *
 * @author MoBaiJun 2022/5/7 14:55
 */
@RestController
@RequestMapping("/all")
public class TestController {

    @GetMapping("/list")
    public Page list() {
        List<String> list = new LinkedList<>();
        list.add("dsdadadgaasdaddas");
        list.add("dsdadadga56asdaddas");
        list.add("dsdadadga56asdaddas");
        list.add("dsdadadga56asdaddas");
        list.add("dsdadadga56asdaddas");
        list.add("dsdadadga56asdaddas");
        list.add("dsdadadaa56sdaddas");
        list.add("dsdadadaa56sdasdaddas");
        list.add("dsdadadaa56sdasdaddas");
        list.add("dsdadadaa56sdasdaddas");
        list.add("dsdadadaa56sdasdas");
        list.add("dsdadadaa56sdasdas");
        list.add("dsdadadaa56sdasdas");
        list.add("dsdadadaa56sdasdas");
        list.add("dsdadadaa56sdasdas");
        list.add("dsdadadaa56sdasdas");
        return new Page<>(list, 15, 2);
    }
}
