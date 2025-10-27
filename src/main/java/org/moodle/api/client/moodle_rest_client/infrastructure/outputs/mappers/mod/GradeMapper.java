package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.mappers.mod;

import org.mapstruct.Mapper;
import org.moodle.api.client.moodle_rest_client.domain.models.Assignment;
import org.moodle.api.client.moodle_rest_client.domain.models.Grade;
import org.moodle.api.client.moodle_rest_client.domain.requests.mod.assign.GetGradesRequest;
import org.moodle.api.client.moodle_rest_client.domain.responses.mod.assign.Grades;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.mod.assign.AssignmentDTO;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.mod.assign.GetGradesRequestDTO;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.mod.assign.GradeDTO;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.mod.assign.GradesDTO;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.mappers.WarningMapper;

import java.util.List;

@Mapper(uses = WarningMapper.class)
public interface GradeMapper {
    Grade toDomain(GradeDTO dto);
    List<Grade> toGradesDomain(List<GradeDTO> dtos);
    Assignment toDomain(AssignmentDTO dto);
    List<Assignment> toAssignmentsDomain(List<AssignmentDTO> dtos);
    Grades toDomain(GradesDTO dto);
    GetGradesRequestDTO toDto(GetGradesRequest dto);
}
