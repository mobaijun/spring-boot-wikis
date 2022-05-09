package com.mobaijun.shell.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mobaijun.shell.mapper.ProjectMilepostMapper;
import com.mobaijun.shell.model.entity.ProjectMilepost;
import com.mobaijun.shell.service.ProjectMilepostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
/**
 * Software：IntelliJ IDEA 2021.3.2
 * ClassName: ProjectMilepostServiceImpl
 * 类描述： 的业务实现类
 * 
 * @author MoBaiJun 2022-05-07 17:16:13
 */
@Slf4j
@Service
public class ProjectMilepostServiceImpl extends ServiceImpl<ProjectMilepostMapper, ProjectMilepost> implements ProjectMilepostService {

    @Resource
    private ProjectMilepostMapper projectMilepostMapper;

    @Override
    public int insetProjectMilepost(ProjectMilepost projectMilepost) {
        return projectMilepostMapper.insert(projectMilepost);
    }

    @Override
    public int updateProjectMilepost(ProjectMilepost projectMilepost) {
        return projectMilepostMapper.updateById(projectMilepost);
    }

    @Override
    public List<ProjectMilepost> selectList(ProjectMilepost projectMilepost) {
        return projectMilepostMapper.selectList(null);
    }

    @Override
    public int deleteById(Long id) {
        return projectMilepostMapper.deleteById(id);
    }

    @Override
    public int batchDelete(Long[] ids) {
        return projectMilepostMapper.deleteBatchIds(Arrays.asList(ids));
    }
}