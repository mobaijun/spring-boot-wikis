package com.mobaijun.controller;

import com.mobaijun.ip2region.core.IpInfo;
import com.mobaijun.ip2region.searcher.Ip2regionSearcher;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: [测试]
 * Author: [mobaijun]
 * Date: [2024/11/27 17:50]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2023.1.4]
 */
@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final Ip2regionSearcher ip2regionSearcher;


    /**
     * <a href="http://localhost:9090/test/test?ip=12.184.77.78">...</a>
     * Description: [测试]
     *
     * @param ip ip地址
     * @return 地址
     */
    @RequestMapping("/test")
    public String test(String ip) {
        IpInfo search = ip2regionSearcher.search(ip);
        return search.getAddressAndIsp();
    }
}
