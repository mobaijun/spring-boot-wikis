package com.mobaijun.shell.converter;

import com.mobaijun.shell.model.entity.ProjectMilepost;
import com.mobaijun.shell.model.vo.ProjectMilepostVo;
import com.mobaijun.shell.model.qo.ProjectMilepostQo;
import com.mobaijun.shell.model.dto.ProjectMilepostDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * 模型转换器
 *
 * @author MoBaiJun 2022-05-07 17:16:13
 */
@Mapper
public interface ProjectMilepostConverterMapper {

    ProjectMilepostConverterMapper INSTANCE = Mappers.getMapper(ProjectMilepostConverterMapper.class);

    /**
     * entity 转 Vo
     *
     * @param projectMilepost  对象
     * @return ProjectMilepostVO VO
     */
    @Mappings({})
    ProjectMilepostVo toVo(ProjectMilepost projectMilepost);

    /**
     * Qo 转 entity
     *
     * @param projectMilepostQo qo
     * @return ProjectMilepost  对象
     */
    @Mappings({})
    ProjectMilepost toQo(ProjectMilepostQo projectMilepostQo);

    /**
     * dto 转 entity
     *
     * @param projectMilepostDto Dto
     * @return ProjectMilepost  对象
     */
    @Mappings({})
    ProjectMilepost toDto(ProjectMilepostDto projectMilepostDto);
}