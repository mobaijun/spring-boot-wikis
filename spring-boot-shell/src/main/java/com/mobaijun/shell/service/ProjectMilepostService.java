package com.mobaijun.shell.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mobaijun.shell.model.entity.ProjectMilepost;

import java.util.List;

/**
 * Software：IntelliJ IDEA 2021.3.2
 * ClassName: ProjectMilepostService
 * 类描述： 的业务接口
 *
 * @author MoBaiJun 2022-05-07 17:16:13
 */
public interface ProjectMilepostService extends IService<ProjectMilepost> {

    /**
     * 新增 ProjectMilepost
     *
     * @param projectMilepost ProjectMilepost 对象
     * @return 操作记录数
     */
    int insetProjectMilepost(ProjectMilepost projectMilepost);

    /**
     * 修改 ProjectMilepost 对象
     *
     * @param projectMilepost ProjectMilepost 对象
     * @return 操作记录数
     */
    int updateProjectMilepost(ProjectMilepost projectMilepost);

    /**
     * 查询全部 ProjectMilepost
     *
     * @param projectMilepost ProjectMilepost 对象
     * @return projectMilepost 集合
     */
    List<ProjectMilepost> selectList(ProjectMilepost projectMilepost);

    /**
     * 删除一个 ProjectMilepost 对象
     *
     * @param id 主键 id
     * @return 操作记录数
     */
    int deleteById(Long id);

    /**
     * 批量删除 ProjectMilepost 对象
     *
     * @param ids id 集合
     * @return 操作记录数
     */
    int batchDelete(Long[] ids);
}