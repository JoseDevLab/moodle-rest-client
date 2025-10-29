package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.mappers.gradereport;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.moodle.api.client.moodle_rest_client.domain.models.UserGrade;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.gradereport.gradeitem.UserGradeDTO;

@Mapper(uses = GradeItemMapper.class)
public interface UserGradeMapper {
    UserGrade toDomain(UserGradeDTO dto);
}
