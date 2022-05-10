package com.mobaijun.jpa.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Software：IntelliJ IDEA 2021.3.2
 * ClassName: UserToken
 * 类描述： 敏捷项目-用户token的实体对象
 *
 * @author MoBaiJun 2022-05-10 14:28:42
 */
@Entity
@Table(name = "lb_user_token")
@org.hibernate.annotations.Table(appliesTo = "lb_user_token", comment = "敏捷项目-用户token")
public class UserToken extends AbstractPersistable<Long> {

    @Column(name = "id", columnDefinition = "bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT  COMMENT `主键id`")
    private Long id;

    @Column(name = "uid", columnDefinition = "int(10) NOT NULL DEFAULT 0 COMMENT '用户id'")
    private Integer uid;

    @Column(name = "appKey", columnDefinition = "varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'appKey'")
    private String appkey;

    @Column(name = "appSecret", columnDefinition = "varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'appSecret'")
    private String appsecret;

    @Column(name = "token", columnDefinition = "varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'token'")
    private String token;

    @Column(name = "token_time", columnDefinition = "int(10) NOT NULL DEFAULT 0 COMMENT 'token过期时间'")
    private Integer tokenTime;

    @Column(name = "refresh_token", columnDefinition = "varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '刷新token'")
    private String refreshToken;

    @Column(name = "refresh_token_time", columnDefinition = "int(10) NOT NULL DEFAULT 0 COMMENT '刷新token过期时间'")
    private Integer refreshTokenTime;
}