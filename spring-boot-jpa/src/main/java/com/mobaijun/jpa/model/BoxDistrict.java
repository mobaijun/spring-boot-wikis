package com.mobaijun.jpa.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Software：IntelliJ IDEA 2021.3.2
 * ClassName: BoxDistrict
 * 类描述： 的实体对象
 * 
 * @author MoBaiJun 2022-05-10 14:30:15
 */
@Entity
@Table(name = "lb_box_district")
@org.hibernate.annotations.Table(appliesTo = "lb_box_district",comment = "区域信息表")
public class BoxDistrict extends AbstractPersistable<Long>{
  
    @Column(name = "lb_box_district_id", columnDefinition = "int(11) NOT NULL AUTO_INCREMENT COMMENT `主键id`")
    private Integer lbBoxDistrictId;
  
    @Column(name = "parent_id", columnDefinition = "int(11) NULL DEFAULT NULL  COMMENT `父id`")
    private Integer parentId;
  
    @Column(name = "dis_name", columnDefinition = "varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT `地名`")
    private String disName;
  
    @Column(name = "project_id", columnDefinition = "bigint(50) NULL DEFAULT NULL  COMMENT `项目id`")
    private Long projectId;
}