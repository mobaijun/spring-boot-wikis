package com.mobaijun.jpa.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Software：IntelliJ IDEA 2021.3.2
 * ClassName: AttendanceRate
 * 类描述： 日考勤率信息表的实体对象
 *
 * @author MoBaiJun 2022-05-10 14:27:19
 */
@Entity
@Table(name = "lb_attendance_rate")
@org.hibernate.annotations.Table(appliesTo = "lb_attendance_rate", comment = "日考勤率信息表")
public class AttendanceRate extends AbstractPersistable<Long> {

    @Column(name = "id", columnDefinition = "bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id'")
    private Long id;

    @Column(name = "day", columnDefinition = "date NULL DEFAULT NULL COMMENT '考勤日期'")
    private LocalDate day;

    @Column(name = "project_id", columnDefinition = "bigint(20) NULL DEFAULT NULL COMMENT '项目id'")
    private Long projectId;

    @Column(name = "team_name", columnDefinition = "varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '班组'")
    private String teamName;

    @Column(name = "labour_count", columnDefinition = "int(11) NULL DEFAULT NULL COMMENT '班组人数'")
    private Integer labourCount;

    @Column(name = "attendance_count", columnDefinition = "int(11) NULL DEFAULT NULL COMMENT '出勤人数'")
    private Integer attendanceCount;

    @Column(name = "create_time", columnDefinition = "datetime(0) NULL DEFAULT NULL COMMENT '创建时间'")
    private LocalDateTime createTime;
}