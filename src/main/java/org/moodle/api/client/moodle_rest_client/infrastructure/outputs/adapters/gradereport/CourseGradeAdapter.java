package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.adapters.gradereport;

import lombok.RequiredArgsConstructor;
import org.moodle.api.client.moodle_rest_client.domain.models.MoodleCredentials;
import org.moodle.api.client.moodle_rest_client.domain.ports.out.gradereport.CourseGradePort;
import org.moodle.api.client.moodle_rest_client.domain.responses.gradereport.overview.CourseGrades;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.client.MoodleHttpClient;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.gradereport.overview.CourseGradesResponseDTO;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.mappers.MoodleCredentialsMapper;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.mappers.gradereport.CourseGradeMapper;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class CourseGradeAdapter implements CourseGradePort {

    private final MoodleHttpClient moodleHttpClient;
    private final CourseGradeMapper responseMapper;
    private final MoodleCredentialsMapper moodleCredentialsMapper;

    private static final String GRADEREPORT_OVERVIEW_GET_COURSE_GRADES = "gradereport_overview_get_course_grades";

    @Override
    public CourseGrades getCourseGrades(MoodleCredentials moodleCredentials, Long userId) {
        Map<String, Object> params = new HashMap<>();
        params.put("userid", userId.toString());

        CourseGradesResponseDTO responseDto = moodleHttpClient.call(
                moodleCredentialsMapper.toDTO(moodleCredentials),
                GRADEREPORT_OVERVIEW_GET_COURSE_GRADES,
                params,
                CourseGradesResponseDTO.class
        );

        if (responseDto == null) {
            return CourseGrades.builder()
                    .grades(java.util.Collections.emptyList())
                    .warnings(java.util.Collections.emptyList())
                    .build();
        }

        return responseMapper.toDomain(responseDto);
    }
}