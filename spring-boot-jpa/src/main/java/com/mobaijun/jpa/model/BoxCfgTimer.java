package com.mobaijun.jpa.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * Software：IntelliJ IDEA 2021.3.2
 * ClassName: BoxCfgTimer
 * 类描述： 获取设备的定时配置的实体对象
 * 
 * @author MoBaiJun 2022-05-10 14:30:15
 */
@Entity
@Table(name = "lb_box_cfg_timer")
@org.hibernate.annotations.Table(appliesTo = "lb_box_cfg_timer",comment = "获取设备的定时配置")
public class BoxCfgTimer extends AbstractPersistable<Long>{
  
    @Column(name = "cfg_timer_id", columnDefinition = "bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键自增Id'")
    private Long cfgTimerId;
  
    @Column(name = "autoid", columnDefinition = "varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '记录号'")
    private String autoid;
  
    @Column(name = "channel", columnDefinition = "varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '线路地址（如果有多个地址，以,分隔）'")
    private String channel;
  
    @Column(name = "weekday", columnDefinition = "varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '\t星期列表：如：日一二三四五六如果值为“三四”表示循环定时 星期三、星期四；如果值为空，表示单次定时；'")
    private String weekday;
  
    @Column(name = "time", columnDefinition = "varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '\t定时时间：循环定时为时:分:秒单次定时为年-月-日 时:分:秒'")
    private String time;
  
    @Column(name = "status", columnDefinition = "varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'true/false 表示合闸/分闸'")
    private String status;
  
    @Column(name = "update_time", columnDefinition = "varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '配置更新时间'")
    private String updateTime;
  
    @Column(name = "create_time", columnDefinition = "timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间'")
    private LocalDateTime createTime;
}