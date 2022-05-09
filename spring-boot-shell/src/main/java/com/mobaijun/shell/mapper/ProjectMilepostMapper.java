package com.mobaijun.shell.mapper;
import T;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mobaijun.mybatis.plus.mapper.ExtendMapper;
import com.mobaijun.mybatis.plus.model.domain.PageParam;
import com.mobaijun.mybatis.plus.model.domain.PageResult;
import com.mobaijun.mybatis.plus.query.LambdaQueryWrapper;
import com.mobaijun.mybatis.plus.toolkit.Wrappers;
import com.mobaijun.shell.converter.ProjectMilepostConverterMapper;
import com.mobaijun.shell.model.entity.ProjectMilepost;
import com.mobaijun.shell.model.qo.ProjectMilepostQo;
import com.mobaijun.shell.model.vo.ProjectMilepostVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;

/**
 * Software：IntelliJ IDEA 2021.3.2
 * ClassName: ProjectMilepostMapper
 * 类描述： 的 Mapper 接口
 *
 * @author MoBaiJun 2022-05-07 17:16:13
 */
@Mapper
public interface ProjectMilepostMapper extends ExtendMapper<ProjectMilepost> {

    /**
     * 分页查询
     *
     * @param pageParam 分页参数
     * @param qo        查询条件
     * @return PageResult<DataSourceConfigVO> 分页结果数据
     */
    default PageResult<ProjectMilepostVo> queryPage(PageParam pageParam, ProjectMilepostQo qo) {
        IPage<ProjectMilepost> page = this.prodPage(pageParam);
        LambdaQueryWrapper<ProjectMilepost> wrapperX = Wrappers.lambdaQuery(ProjectMilepostQo.class)
                .likeIfPresent(ProjectMilepost::getEndTime, qo.getProjectNode());

        this.selectPage(page, wrapperX);
        IPage<ProjectMilepostVo> voPage = page.convert(ProjectMilepostConverterMapper.INSTANCE::toVo);
        return new PageResult<>(voPage.getRecords(), voPage.getTotal());
    }

    @Override
    int insertBatchSomeColumn(Collection<ProjectMilepost> list);
}