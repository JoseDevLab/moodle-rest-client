package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.adapters.mod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.moodle.api.client.moodle_rest_client.domain.models.MoodleCredentials;
import org.moodle.api.client.moodle_rest_client.domain.ports.out.GradePort;
import org.moodle.api.client.moodle_rest_client.domain.requests.mod.assign.GetGradesRequest;
import org.moodle.api.client.moodle_rest_client.domain.responses.mod.assign.Grades;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.client.MoodleHttpClient;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.mod.assign.GetGradesRequestDTO;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.mod.assign.GradesDTO;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.mappers.MoodleCredentialsMapper;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.mappers.mod.GradeMapper;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class GradeAdapter implements GradePort {

    private final ObjectMapper objectMapper;
    private final MoodleHttpClient moodleHttpClient;
    private final GradeMapper gradeMapper;
    private final MoodleCredentialsMapper moodleCredentialsMapper;

    private static final String MOD_ASSIGN_GET_GRADES = "mod_assign_get_grades";

    @Override
    public Grades getGrades(MoodleCredentials moodleCredentials, GetGradesRequest dto) {
        GetGradesRequestDTO requestDTO = gradeMapper.toDto(dto);
        Map<String, Object> requestBody = objectMapper.convertValue(
                requestDTO,
                new TypeReference<Map<String, Object>>() {}
        );
        GradesDTO gradesDTO = moodleHttpClient.call(
                moodleCredentialsMapper.toDTO(moodleCredentials),
                MOD_ASSIGN_GET_GRADES,
                requestBody,
                GradesDTO.class
        );
        if (gradesDTO == null)
            return Grades.builder()
                    .assignments(Collections.emptyList())
                    .warnings(Collections.emptyList())
                    .build();
        return gradeMapper.toDomain(gradesDTO);
    }
}
