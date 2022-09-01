package com.mobaijun.config;

import com.mobaijun.properties.InfluxdbProperties;
import lombok.extern.slf4j.Slf4j;
import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.BatchPoints;
import org.influxdb.dto.Point;
import org.influxdb.dto.Pong;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;
import org.springframework.beans.BeanWrapperImpl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Software：IntelliJ IDEA 2021.2 x64
 * Author: <a href="https://www.mobaijun.com">...</a>
 * Date: 2021/11/22 10:26
 * ClassName:InfluxDbConnection
 * 类描述： influxdb操作类
 */
@Slf4j
public class InfluxDbConnection {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 连接地址
     */
    private String url;

    /**
     * 数据库
     */
    private String database;

    /**
     * 保留策略
     */
    private String retentionPolicy;

    /**
     * 保存时间
     */
    private String retentionPolicyTime;

    private InfluxDB influxDB;

    /**
     * 属性
     */
    private InfluxdbProperties influxdbProperties;


    /**
     * 初始化influxDbBuild
     */
    public InfluxDbConnection(String username, String password, String url, String database,
                              String retentionPolicy, String retentionPolicyTime) {
        this.username = username;
        this.password = password;
        this.url = url;
        this.database = database;
        this.retentionPolicy = retentionPolicy == null || retentionPolicy.equals("") ? "default" : retentionPolicy;
        this.retentionPolicyTime = retentionPolicyTime;
        influxDbBuild();
    }

    /**
     * 创建数据库
     */
    public void createDB(String... dbName) {
        if (dbName.length > 0) {
            influxDB.createDatabase(dbName[0]);
            return;
        }
        if (influxdbProperties.getDatabase() == null) {
            log.error("如参数不指定数据库名,配置文件 spring.influx.database 必须指定");
            return;
        }
        influxDB.createDatabase(influxdbProperties.getDatabase());
    }

    /**
     * 删除数据库
     */
    public void deleteDB(String... dbName) {
        if (dbName.length > 0) {
            influxDB.deleteDatabase(dbName[0]);
            return;
        }
        if (influxdbProperties.getDatabase() == null) {
            log.error("如参数不指定数据库名,配置文件 spring.influx.database 必须指定");
            return;
        }
        influxDB.deleteDatabase(influxdbProperties.getDatabase());
    }

    /**
     * 测试连接是否正常
     */
    public boolean ping() {
        boolean isConnected = false;
        Pong pong;
        try {
            pong = influxDB.ping();
            if (pong != null) {
                isConnected = true;
            }
        } catch (Exception e) {
            log.error(e.getStackTrace().toString());
            e.printStackTrace();
        }
        return isConnected;
    }

    /**
     * 连接时序数据库 ，若不存在则创建
     */
    public InfluxDB influxDbBuild() {
        if (influxDB == null) {
            influxDB = InfluxDBFactory.connect(url, username, password);
        }
        try {
            createDB(database);
            influxDB.setDatabase(database);
        } catch (Exception e) {
            log.error("create influx db failed, error: {}", e.getMessage());
        } finally {
            if (retentionPolicy.equalsIgnoreCase(retentionPolicy)) {
                createDefaultRetentionPolicy();
            }
            influxDB.setRetentionPolicy(retentionPolicy);
        }
        influxDB.setLogLevel(InfluxDB.LogLevel.NONE);
        return influxDB;
    }

    /**
     * 创建自定义保留策略
     *
     * @param policyName  策略名
     * @param duration    保存天数
     * @param replication 保存副本数量
     * @param isDefault   是否设为默认保留策略
     */
    public void createRetentionPolicy(String policyName, String duration, int replication, Boolean isDefault) {
        String sql = String.format("CREATE RETENTION POLICY \"%s\" ON \"%s\" DURATION %s REPLICATION %s ", policyName,
                database, duration, replication);
        if (isDefault) {
            sql = sql + " DEFAULT";
        }
        this.query(sql);
    }

    /**
     * 创建默认的保留策略
     * <p>
     * <p>
     * 策略名：default，保存天数：730天，保存副本数量：1
     * 设为默认保留策略
     */
    public void createDefaultRetentionPolicy() {
        String command = String.format("CREATE RETENTION POLICY \"%s\" ON \"%s\" DURATION %s REPLICATION %s DEFAULT",
                retentionPolicy, database, retentionPolicyTime, 1);
        this.query(command);
    }

    /**
     * 查询
     *
     * @param command 查询语句
     */
    public QueryResult query(String command) {
        return influxDB.query(new Query(command, database));
    }


    /**
     * 插入
     *
     * @param measurement 表
     * @param tags        标签
     * @param fields      字段
     */
    public void insert(String measurement, Map<String, String> tags, Map<String, Object> fields, long time,
                       TimeUnit timeUnit) {
        Point.Builder builder = Point.measurement(measurement);
        builder.tag(tags);
        builder.fields(fields);
        if (0 != time) {
            builder.time(time, timeUnit);
        }
        influxDB.write(database, retentionPolicy, builder.build());
    }

    /**
     * 插入
     *
     * @param measurement 表
     * @param tags        标签
     * @param fields      字段
     */
    public void insert(String measurement, Map<String, String> tags, Map<String, Object> fields) {
        insert(measurement, tags, fields, System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    /**
     * 批量写入
     *
     * @param batchPoints 批量写入
     */
    public void batchInsert(BatchPoints batchPoints) {
        influxDB.write(batchPoints);
    }

    /**
     * 批量写入数据
     *
     * @param database        数据库
     * @param retentionPolicy 保存策略
     * @param consistency     一致性
     * @param records         要保存的数据（调用BatchPoints.lineProtocol()可得到一条record）
     */
    public void batchInsert(final String database, final String retentionPolicy, final InfluxDB.ConsistencyLevel consistency,
                            final List<String> records) {
        influxDB.write(database, retentionPolicy, consistency, records);
    }

    /**
     * 删除
     *
     * @param command 删除语句
     * @return 返回错误信息
     */
    public String deleteMeasurementData(String command) {
        QueryResult result = influxDB.query(new Query(command, database));
        return result.getError();
    }

    /**
     * 关闭数据库
     */
    public void close() {
        influxDB.close();
    }

    /**
     * 构建Point
     *
     * @param measurement measurement名称
     * @param time        时间
     * @param fields      fields
     * @return Point
     */
    public Point pointBuilder(String measurement, long time, Map<String, String> tags, Map<String, Object> fields) {
        Point point = Point.measurement(measurement).time(time, TimeUnit.MILLISECONDS).tag(tags).fields(fields).build();
        return point;
    }

    /**
     * 查询方法
     *
     * @param clazz 封装的类
     * @param sql   查询SQL
     * @param <T>   不定义类型
     */
    public <T> List<T> getInfluxQuery(final Class<T> clazz, final String sql) {
        QueryResult results = influxDB.query(new Query(sql, database));
        if (results != null) {
            if (results.getResults() == null) {
                return null;
            }
            List<Object> list = new ArrayList<>();
            for (QueryResult.Result result : results.getResults()) {
                List<QueryResult.Series> series = result.getSeries();
                if (series == null) {
                    continue;
                }
                for (QueryResult.Series serie : series) {
                    List<List<Object>> values = serie.getValues();
                    List<String> columns = serie.getColumns();
                    // 构建Bean
                    list.addAll(getQueryData(clazz, columns, values));
                }
            }
            return (List<T>) list;
        }
        return null;
    }

    /**
     * 构建查询数据
     */
    public <T> List<T> getQueryData(Class<T> clazz, List<String> columns, List<List<Object>> values) {
        List results = new ArrayList<>();
        for (List<Object> list : values) {
            BeanWrapperImpl bean = null;
            Object result = null;
            try {
                result = clazz.newInstance();
                bean = new BeanWrapperImpl(result);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < list.size(); i++) {
                // 字段名
                String filedName = columns.get(i);
                try {
                    Field field = clazz.getDeclaredField(filedName);
                } catch (NoSuchFieldException e) {
                    continue;
                }
                // 值
                Object value = list.get(i);
                bean.setPropertyValue(filedName, value);
            }
            results.add(result);
        }
        return results;
    }
}
