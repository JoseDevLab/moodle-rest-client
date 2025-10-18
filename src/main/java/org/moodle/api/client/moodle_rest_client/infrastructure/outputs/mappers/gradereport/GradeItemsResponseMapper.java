package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.mappers.gradereport;

import org.mapstruct.Mapper;
import org.moodle.api.client.moodle_rest_client.domain.responses.gradereport.gradeItem.GradeItems;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.gradereport.gradeitem.UserGradesResponseDTO;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.mappers.WarningMapper;

@Mapper(uses = {UserGradeMapper.class, WarningMapper.class})
public interface GradeItemsResponseMapper {
    GradeItems toDomain(UserGradesResponseDTO dto);
}
