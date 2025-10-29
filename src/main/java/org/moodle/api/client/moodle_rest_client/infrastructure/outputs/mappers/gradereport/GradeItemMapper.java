package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.mappers.gradereport;

import org.mapstruct.Mapper;
import org.moodle.api.client.moodle_rest_client.domain.models.GradeItem;
import org.moodle.api.client.moodle_rest_client.domain.requests.gradereport.user.GetGradeItemsRequest;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.gradereport.gradeitem.GradeItemDTO;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.gradereport.user.GetGradeItemsRequestDTO;

import java.util.List;

@Mapper
public interface GradeItemMapper {
    GradeItem toDomain(GradeItemDTO dto);

    List<GradeItem> toDomain(List<GradeItemDTO> dtos);

    GetGradeItemsRequestDTO toDto(GetGradeItemsRequest request);
}