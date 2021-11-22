package com.mobaijun;

import com.mobaijun.pojo.TestModel;
import com.mobaijun.service.InfluxdbService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringBootInfluxdbApplicationTests {

    @Autowired
    private InfluxdbService influxdbService;

    @Test
    void contextLoads() {
        TestModel testModel = new TestModel();
        for (int i = 0; i < 10000; i++) {
            testModel.setHost("127.0.0.1");
            testModel.setName("MoBai" + i);
            testModel.setTime(String.valueOf(System.currentTimeMillis()));
            testModel.setPort("102");
            testModel.setValue("1" + i);
            testModel.setValueType("string");
            testModel.setTableName("TEST");
            influxdbService.insertTest(testModel);
        }
    }


    @Test
    void getListAll() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM \"ZJDYBTSE\" limit 100");
        List<TestModel> allList = influxdbService.getAllList(sql);
        allList.stream().forEach(System.out::println);
    }


    /**
     * 清理数据
     */
    @Test
    void deleteDbName() {
        String dbName = "127.0.0.1_102";
        influxdbService.deleteDbName(dbName);
    }
}
