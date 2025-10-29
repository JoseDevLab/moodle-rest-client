package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.adapters.gradereport;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.moodle.api.client.moodle_rest_client.domain.exceptions.MoodleApiException;
import org.moodle.api.client.moodle_rest_client.domain.ports.out.gradereport.GradeItemPort;
import org.moodle.api.client.moodle_rest_client.domain.requests.gradereport.user.GetGradeItemsRequest;
import org.moodle.api.client.moodle_rest_client.domain.responses.gradereport.gradeItem.GradeItems;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.client.MoodleHttpClient;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.gradereport.gradeitem.UserGradesResponseDTO;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.gradereport.user.GetGradeItemsRequestDTO;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.mappers.gradereport.GradeItemMapper;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.mappers.gradereport.GradeItemsResponseMapper;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class GradeItemAdapter implements GradeItemPort {

    private final ObjectMapper objectMapper;
    private final MoodleHttpClient moodleHttpClient;
    private final GradeItemsResponseMapper responseMapper;

    private static final String GRADEREPORT_USER_GET_GRADE_ITEMS = "gradereport_user_get_grade_items";
    private final GradeItemMapper gradeItemMapper;

    @Override
    public GradeItems getUserGradeItems(Long courseId) {
        Map<String, Object> params = new HashMap<>();
        params.put("courseid", courseId.toString());

        UserGradesResponseDTO responseDto = moodleHttpClient.call(GRADEREPORT_USER_GET_GRADE_ITEMS, params, UserGradesResponseDTO.class);

        if (responseDto == null) {
            return GradeItems.builder()
                    .userGrades(Collections.emptyList())
                    .warnings(Collections.emptyList())
                    .build();
        }

        return responseMapper.toDomain(responseDto);
    }

    @Override
    public GradeItems getUserGradeItems(GetGradeItemsRequest request) throws MoodleApiException {
        GetGradeItemsRequestDTO requestDTO = gradeItemMapper.toDto(request);
        Map<String, Object> params = objectMapper.convertValue(
                requestDTO,
                new TypeReference<Map<String, Object>>() {}
        );
        UserGradesResponseDTO responseDto = moodleHttpClient.call(GRADEREPORT_USER_GET_GRADE_ITEMS, params, UserGradesResponseDTO.class);
        if (responseDto == null) {
            return GradeItems.builder()
                    .userGrades(Collections.emptyList())
                    .warnings(Collections.emptyList())
                    .build();
        }
        return responseMapper.toDomain(responseDto);
    }
}