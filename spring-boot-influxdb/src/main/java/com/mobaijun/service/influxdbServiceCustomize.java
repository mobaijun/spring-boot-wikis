package com.mobaijun.service;

import org.influxdb.BatchOptions;
import org.influxdb.InfluxDB;
import org.influxdb.dto.BatchPoints;
import org.influxdb.dto.Point;
import org.influxdb.dto.Pong;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;

import java.util.List;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * Software：IntelliJ IDEA 2021.2 x64
 * Author: <a href="https://www.mobaijun.com">...</a>
 * Date: 2021/11/22 14:58
 * InterfaceName:influxdbServiceCustomize
 * 接口描述： 自定义
 */
public class influxdbServiceCustomize implements InfluxDB {

    @Override
    public InfluxDB setLogLevel(LogLevel logLevel) {
        return null;
    }

    @Override
    public InfluxDB enableGzip() {
        return null;
    }

    @Override
    public InfluxDB disableGzip() {
        return null;
    }

    @Override
    public boolean isGzipEnabled() {
        return false;
    }

    @Override
    public InfluxDB enableBatch() {
        return null;
    }

    @Override
    public InfluxDB enableBatch(BatchOptions batchOptions) {
        return null;
    }

    @Override
    public InfluxDB enableBatch(int actions, int flushDuration, TimeUnit flushDurationTimeUnit) {
        return null;
    }

    @Override
    public InfluxDB enableBatch(int actions, int flushDuration, TimeUnit flushDurationTimeUnit, ThreadFactory threadFactory) {
        return null;
    }

    @Override
    public InfluxDB enableBatch(int actions, int flushDuration, TimeUnit flushDurationTimeUnit, ThreadFactory threadFactory, BiConsumer<Iterable<Point>, Throwable> exceptionHandler, ConsistencyLevel consistency) {
        return null;
    }

    @Override
    public InfluxDB enableBatch(int actions, int flushDuration, TimeUnit flushDurationTimeUnit, ThreadFactory threadFactory, BiConsumer<Iterable<Point>, Throwable> exceptionHandler) {
        return null;
    }

    @Override
    public void disableBatch() {

    }

    @Override
    public boolean isBatchEnabled() {
        return false;
    }

    @Override
    public Pong ping() {
        return null;
    }

    @Override
    public String version() {
        return null;
    }

    @Override
    public void write(Point point) {

    }

    @Override
    public void write(String records) {

    }

    @Override
    public void write(List<String> records) {

    }

    @Override
    public void write(String database, String retentionPolicy, Point point) {

    }

    @Override
    public void write(int udpPort, Point point) {

    }

    @Override
    public void write(BatchPoints batchPoints) {

    }

    @Override
    public void writeWithRetry(BatchPoints batchPoints) {

    }

    @Override
    public void write(String database, String retentionPolicy, ConsistencyLevel consistency, String records) {

    }

    @Override
    public void write(String database, String retentionPolicy, ConsistencyLevel consistency, TimeUnit precision, String records) {

    }

    @Override
    public void write(String database, String retentionPolicy, ConsistencyLevel consistency, List<String> records) {

    }

    @Override
    public void write(String database, String retentionPolicy, ConsistencyLevel consistency, TimeUnit precision, List<String> records) {

    }

    @Override
    public void write(int udpPort, String records) {

    }

    @Override
    public void write(int udpPort, List<String> records) {

    }

    @Override
    public QueryResult query(Query query) {
        return null;
    }

    @Override
    public void query(Query query, Consumer<QueryResult> onSuccess, Consumer<Throwable> onFailure) {

    }

    @Override
    public void query(Query query, int chunkSize, Consumer<QueryResult> onNext) {

    }

    @Override
    public void query(Query query, int chunkSize, BiConsumer<Cancellable, QueryResult> onNext) {

    }

    @Override
    public void query(Query query, int chunkSize, Consumer<QueryResult> onNext, Runnable onComplete) {

    }

    @Override
    public void query(Query query, int chunkSize, BiConsumer<Cancellable, QueryResult> onNext, Runnable onComplete) {

    }

    @Override
    public void query(Query query, int chunkSize, BiConsumer<Cancellable, QueryResult> onNext, Runnable onComplete, Consumer<Throwable> onFailure) {

    }

    @Override
    public QueryResult query(Query query, TimeUnit timeUnit) {
        return null;
    }

    @Override
    public void createDatabase(String name) {

    }

    @Override
    public void deleteDatabase(String name) {

    }

    @Override
    public List<String> describeDatabases() {
        return null;
    }

    @Override
    public boolean databaseExists(String name) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public void close() {

    }

    @Override
    public InfluxDB setConsistency(ConsistencyLevel consistency) {
        return null;
    }

    @Override
    public InfluxDB setDatabase(String database) {
        return null;
    }

    @Override
    public InfluxDB setRetentionPolicy(String retentionPolicy) {
        return null;
    }

    @Override
    public void createRetentionPolicy(String rpName, String database, String duration, String shardDuration, int replicationFactor, boolean isDefault) {

    }

    @Override
    public void createRetentionPolicy(String rpName, String database, String duration, int replicationFactor, boolean isDefault) {

    }

    @Override
    public void createRetentionPolicy(String rpName, String database, String duration, String shardDuration, int replicationFactor) {

    }

    @Override
    public void dropRetentionPolicy(String rpName, String database) {

    }
}
