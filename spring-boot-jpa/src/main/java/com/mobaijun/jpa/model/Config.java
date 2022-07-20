package com.mobaijun.jpa.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: Config
 * class description：
 *
 * @author MoBaiJun 2022/5/13 12:51
 */
@Entity
@Table(name = "kjs_nine_config")
public class Config extends AbstractPersistable<Long> {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "token")
    public String token;

    @Column(name = "reqHeader")
    public String reqHeader;

    /**
     * 接种成员ID
     */
    @Column(name = "memberId")
    public Integer memberId;
    /**
     * 接种成员身份证号码
     */
    @Column(name = "idCard")
    public String idCard;
    /**
     * 接种成员姓名
     */
    @Column(name = "memberName")
    public String memberName;
    /**
     * 选择的地区代码
     */
    @Column(name = "regionCode")
    public String regionCode;
    /**
     * 调用接口时返回的set-cookie
     */
    @Column(name = "cookie")
    public String cookie;

    /**
     * 抢购是否成功
     * false表示疫苗已抢光
     */
    @Column(name = "success")
    public boolean success;

    /**
     * 加密参数st
     */
    @Column(name = "st")
    public String st;
}
