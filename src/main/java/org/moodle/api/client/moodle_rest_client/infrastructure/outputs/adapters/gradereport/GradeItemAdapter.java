package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.adapters.gradereport;

import lombok.RequiredArgsConstructor;
import org.moodle.api.client.moodle_rest_client.domain.ports.out.gradereport.GradeItemPort;
import org.moodle.api.client.moodle_rest_client.domain.responses.gradereport.gradeItem.GradeItems;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.client.MoodleHttpClient;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.gradereport.gradeitem.UserGradesResponseDTO;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.mappers.gradereport.GradeItemsResponseMapper;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class GradeItemAdapter implements GradeItemPort {

    private final MoodleHttpClient moodleHttpClient;
    private final GradeItemsResponseMapper responseMapper;

    private static final String WS_FUNCTION = "gradereport_user_get_grade_items";

    @Override
    public GradeItems getUserGradeItems(Long courseId) {
        Map<String, Object> params = new HashMap<>();
        params.put("courseid", courseId.toString());

        UserGradesResponseDTO responseDto = moodleHttpClient.call(WS_FUNCTION, params, UserGradesResponseDTO.class);

        if (responseDto == null) {
            return GradeItems.builder()
                    .userGrades(Collections.emptyList())
                    .warnings(Collections.emptyList())
                    .build();
        }

        return responseMapper.toDomain(responseDto);
    }
}