package com.mobaijun.shell.model.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
  
import java.time.LocalDateTime;
/**
 * Software：IntelliJ IDEA 2021.3.2
 * ClassName: ProjectMilepostDto
 * 类描述： 的 Dto 新增对象
 * 
 * @author MoBaiJun 2022-05-07 17:16:13
 */
@Data
@ApiModel(description = "新增对象")
public class ProjectMilepostDto  {
      
    @ApiModelProperty(name = "id", value = "里程碑id", dataType = "Long")
    private Long id;
      
    @ApiModelProperty(name = "startTime", value = "项目时间", dataType = "LocalDateTime")
    private LocalDateTime startTime;
      
    @ApiModelProperty(name = "endTime", value = "结束时间", dataType = "LocalDateTime")
    private LocalDateTime endTime;
      
    @ApiModelProperty(name = "status", value = "0基础施工 1主体施工 2二次结构 3 装饰工程 4完成俊工", dataType = "Integer")
    private Integer status;
      
    @ApiModelProperty(name = "projectId", value = "项目id", dataType = "Long")
    private Long projectId;
      
    @ApiModelProperty(name = "userId", value = "用户id", dataType = "Long")
    private Long userId;
      
    @ApiModelProperty(name = "projectNode", value = "项目节点", dataType = "String")
    private String projectNode;
}