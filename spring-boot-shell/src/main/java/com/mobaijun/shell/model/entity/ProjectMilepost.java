package com.mobaijun.shell.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Software：IntelliJ IDEA 2021.3.2
 * ClassName: ProjectMilepost
 * 类描述： 的实体对象
 * 
 * @author MoBaiJun 2022-05-07 17:16:13
 */
@Data
@TableName("lb_project_milepost")
@ApiModel(description = "实体对象")
public class ProjectMilepost {
  
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(name = "id", value = "里程碑id", dataType = "Long")
    private Long id;
  
    @TableField(value = "startTime")
    @ApiModelProperty(name = "startTime", value = "项目时间", dataType = "LocalDateTime")
    private LocalDateTime startTime;
  
    @TableField(value = "endTime")
    @ApiModelProperty(name = "endTime", value = "结束时间", dataType = "LocalDateTime")
    private LocalDateTime endTime;
  
    @TableField(value = "status")
    @ApiModelProperty(name = "status", value = "0基础施工 1主体施工 2二次结构 3 装饰工程 4完成俊工", dataType = "Integer")
    private Integer status;
  
    @TableField(value = "projectId")
    @ApiModelProperty(name = "projectId", value = "项目id", dataType = "Long")
    private Long projectId;
  
    @TableField(value = "userId")
    @ApiModelProperty(name = "userId", value = "用户id", dataType = "Long")
    private Long userId;
  
    @TableField(value = "projectNode")
    @ApiModelProperty(name = "projectNode", value = "项目节点", dataType = "String")
    private String projectNode;
}
