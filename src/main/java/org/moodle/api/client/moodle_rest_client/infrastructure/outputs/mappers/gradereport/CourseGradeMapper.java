package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.mappers.gradereport;

import org.mapstruct.Mapper;
import org.moodle.api.client.moodle_rest_client.domain.models.CourseGrade;
import org.moodle.api.client.moodle_rest_client.domain.responses.gradereport.overview.CourseGrades;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.gradereport.overview.CourseGradeDTO;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.gradereport.overview.CourseGradesResponseDTO;

@Mapper
public interface CourseGradeMapper {
    CourseGrade toDomain(CourseGradeDTO dto);
    CourseGrades toDomain(CourseGradesResponseDTO dto);
}