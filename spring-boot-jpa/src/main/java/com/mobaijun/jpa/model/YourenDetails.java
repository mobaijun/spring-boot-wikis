package com.mobaijun.jpa.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * Software：IntelliJ IDEA 2021.3.2
 * ClassName: YourenDetails
 * 类描述： 的实体对象
 *
 * @author MoBaiJun 2022-05-10 14:31:20
 */
@Entity
@Table(name = "lb_youren_details")
@org.hibernate.annotations.Table(appliesTo = "lb_youren_details", comment = "")
public class YourenDetails extends AbstractPersistable<Long> {

    @Column(name = "youren_details_id", columnDefinition = "bigint(20) NOT NULL AUTO_INCREMENT  COMMENT `主键id`")
    private Long yourenDetailsId;

    @Column(name = "device_name", columnDefinition = "varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '设备名称'")
    private String deviceName;

    @Column(name = "device_no", columnDefinition = "varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '设备号'")
    private String deviceNo;

    @Column(name = "status", columnDefinition = "int(2) NULL DEFAULT NULL COMMENT '开关状态-  0-关闭 1-开启  2:离线'")
    private Integer status;

    @Column(name = "type", columnDefinition = "int(2) NULL DEFAULT NULL COMMENT '联动开关:  0-关闭 1-开启'")
    private Integer type;

    @Column(name = "project_id", columnDefinition = "bigint(20) NULL DEFAULT NULL COMMENT '项目id'")
    private Long projectId;

    @Column(name = "variable_name", columnDefinition = "varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL")
    private String variableName;

    @Column(name = "slave_name", columnDefinition = "varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL")
    private String slaveName;

    @Column(name = "online", columnDefinition = "int(2) NULL DEFAULT NULL COMMENT '0离线；1在线'")
    private Integer online;

    @Column(name = "data_point_ids", columnDefinition = "varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '变量id：即开关、按钮等，逗号分隔'")
    private String dataPointIds;

    @Column(name = "duration", columnDefinition = "int(11) NULL DEFAULT NULL COMMENT '喷淋的时长'")
    private Integer duration;

    @Column(name = "interval_time", columnDefinition = "int(11) NULL DEFAULT NULL COMMENT '喷淋间隔时间'")
    private Integer intervalTime;

    @Column(name = "aqi", columnDefinition = "int(11) NULL DEFAULT 150 COMMENT 'AQI阈值'")
    private Integer aqi;

    @Column(name = "valve_status", columnDefinition = "int(1) NULL DEFAULT NULL COMMENT '阀门状态: 0-开启 1-关闭'")
    private Integer valveStatus;

    @Column(name = "enterprise_id", columnDefinition = "bigint(20) NULL DEFAULT NULL COMMENT '企业Id'")
    private Long enterpriseId;

    @Column(name = "config_id", columnDefinition = "bigint(11) NULL DEFAULT NULL COMMENT '厂商id'")
    private Long configId;

    @Column(name = "create_time", columnDefinition = "datetime(0) NULL DEFAULT NULL COMMENT '创建时间'")
    private LocalDateTime createTime;
}