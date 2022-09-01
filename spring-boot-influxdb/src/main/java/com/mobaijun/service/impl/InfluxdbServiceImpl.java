package com.mobaijun.service.impl;

import com.mobaijun.config.InfluxDbConnection;
import com.mobaijun.config.SpringContextHolder;
import com.mobaijun.pojo.TestModel;
import com.mobaijun.service.InfluxdbService;
import org.influxdb.InfluxDBException;
import org.influxdb.dto.BatchPoints;
import org.influxdb.dto.Point;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Software：IntelliJ IDEA 2021.2 x64
 * Author: <a href="https://www.mobaijun.com">...</a>
 * Date: 2021/11/22 11:14
 * ClassName:influxdbServiceImpl
 * 类描述： 测试实现
 */
@Service
public class InfluxdbServiceImpl implements InfluxdbService {

    private InfluxDbConnection influxDbConnect = SpringContextHolder.getBean(InfluxDbConnection.class);

    @Override
    public void insertTest(TestModel testModel) {
        /**
         * java.lang.IllegalArgumentException: Expecting a non-empty string for measurement
         * https://github.com/influxdata/influxdb-java/issues/361
         */
        // 判断是否链接
        if (influxDbConnect.ping()) {
            BatchPoints points = BatchPoints.builder().build();
            // 在influxDB中， 我们所有的值，均保存为String类型，针对不同的应用，可以根据value_type进行特殊处理
            long millis = System.currentTimeMillis();
            points.point(
                    Point.measurement(testModel.getTableName())
                            .time(millis, TimeUnit.MILLISECONDS)
                            .tag("host", testModel.getHost())
                            .tag("name", testModel.getName())
                            .tag("port", testModel.getPort())
                            .tag("valueType", testModel.getValueType())
                            .addField("event_time", millis)
                            .addField("value", testModel.getValue())
                            .build()
            );
            // 批量写入influxDB
            if (points.getPoints().size() > 0) {
                if (influxDbConnect == null) {
                    influxDbConnect.createDB("127.0.0.1_102");
                }
                try {
                    influxDbConnect.batchInsert(points);
                } catch (InfluxDBException.DatabaseNotFoundException e) {
                    influxDbConnect.influxDbBuild();
                }
            }
        }
    }

    @Override
    public List<TestModel> getAllList(StringBuilder sql) {
        List<TestModel> influxQuery = influxDbConnect.getInfluxQuery(TestModel.class, String.valueOf(sql));
        return influxQuery;
    }

    @Override
    public void deleteDbName(String dbName) {
        influxDbConnect.deleteDB(dbName);
    }
}

