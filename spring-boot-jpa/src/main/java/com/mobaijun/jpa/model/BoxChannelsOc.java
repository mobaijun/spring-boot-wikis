package com.mobaijun.jpa.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * Software：IntelliJ IDEA 2021.3.2
 * ClassName: BoxChannelsOc
 * 类描述： 获取设备的开关状态的实体对象
 *
 * @author MoBaiJun 2022-05-10 14:30:15
 */
@Entity
@Table(name = "lb_box_channels_oc")
@org.hibernate.annotations.Table(appliesTo = "lb_box_channels_oc", comment = "获取设备的开关状态")
public class BoxChannelsOc extends AbstractPersistable<Long> {

    @Column(name = "channels_oc_id", columnDefinition = "bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键自增Id'")
    private Long channelsOcId;

    @Column(name = "addr", columnDefinition = "varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '线路地址'")
    private String addr;

    @Column(name = "oc", columnDefinition = "varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '线路开关状态:true开;fase关'")
    private String oc;

    @Column(name = "oc_time", columnDefinition = "varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '线路开关状态变更时间'")
    private String ocTime;

    @Column(name = "update_time", columnDefinition = "varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '采集时间(更新时间)'")
    private String updateTime;

    @Column(name = "create_time", columnDefinition = "timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间'")
    private LocalDateTime createTime;

    @Column(name = "mac", columnDefinition = "varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'MAC地址'")
    private String mac;
}