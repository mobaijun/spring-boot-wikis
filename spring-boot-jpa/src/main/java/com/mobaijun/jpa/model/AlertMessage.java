package com.mobaijun.jpa.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * Software：IntelliJ IDEA 2021.3.2
 * ClassName: AlertMessage
 * 类描述： 鲁班首页的警报消息的实体对象
 *
 * @author MoBaiJun 2022-05-10 14:26:38
 */
@Entity
@Table(name = "lb_alert_message")
@org.hibernate.annotations.Table(appliesTo = "lb_alert_message", comment = "鲁班首页的警报消息")
public class AlertMessage extends AbstractPersistable<Long> {

    @Column(name = "id", columnDefinition = "bigint(8) NOT NULL AUTO_INCREMENT COMMENT '主键id，自增长'")
    private Long id;

    @Column(name = "msg_type", columnDefinition = "int(2) NULL DEFAULT NULL COMMENT '1:塔吊，2:升降机，3:用电(暂定如此)'")
    private Integer msgType;

    @Column(name = "msg_title", columnDefinition = "varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '消息标题'")
    private String msgTitle;

    @Column(name = "msg_content", columnDefinition = "varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '消息内容'")
    private String msgContent;

    @Column(name = "level", columnDefinition = "int(1) NULL DEFAULT 1 COMMENT '消息级别: 0:普通, 1:告警, 2: 严重'")
    private Integer level;

    @Column(name = "received", columnDefinition = "int(1) NULL DEFAULT 0 COMMENT '是否已读 (0:未读, 1:已读)'")
    private Integer received;

    @Column(name = "project_id", columnDefinition = "int(8) NULL DEFAULT NULL COMMENT '项目id'")
    private Integer projectId;

    @Column(name = "enterprise_id", columnDefinition = "bigint(20) NULL DEFAULT NULL COMMENT '企业id'")
    private Integer enterpriseId;

    @Column(name = "user_id", columnDefinition = "bigint(20) NULL DEFAULT NULL COMMENT '用户id (指定具体用户接收)'")
    private Integer userId;

    @Column(name = "create_time", columnDefinition = "datetime(0) NULL DEFAULT NULL COMMENT '创建时间'")
    private LocalDateTime createTime;
}