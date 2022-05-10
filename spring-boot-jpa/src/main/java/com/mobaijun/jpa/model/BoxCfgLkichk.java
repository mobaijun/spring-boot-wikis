package com.mobaijun.jpa.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * Software：IntelliJ IDEA 2021.3.2
 * ClassName: BoxCfgLkichk
 * 类描述： 获取设备的漏电自检配置的实体对象
 *
 * @author MoBaiJun 2022-05-10 14:30:15
 */
@Entity
@Table(name = "lb_box_cfg_lkichk")
@org.hibernate.annotations.Table(appliesTo = "lb_box_cfg_lkichk", comment = "获取设备的漏电自检配置")
public class BoxCfgLkichk extends AbstractPersistable<Long> {

    @Column(name = "cfg_lkichk_id", columnDefinition = "bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键自增Id'")
    private Long cfgLkichkId;

    @Column(name = "enable_check", columnDefinition = "varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否启用漏电自检:true/false'")
    private String enableCheck;

    @Column(name = "last_check_date", columnDefinition = "varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上一次执行自检的时间'")
    private String lastCheckDate;

    @Column(name = "check_date_cfg", columnDefinition = "varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '自检配置时间，格式: 日,时,分'")
    private String checkDateCfg;

    @Column(name = "create_time", columnDefinition = "timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间'")
    private LocalDateTime createTime;
}