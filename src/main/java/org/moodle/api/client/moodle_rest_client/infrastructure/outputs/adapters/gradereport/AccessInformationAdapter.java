package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.adapters.gradereport;

import lombok.RequiredArgsConstructor;
import org.moodle.api.client.moodle_rest_client.domain.ports.out.gradereport.AccessInformationPort;
import org.moodle.api.client.moodle_rest_client.domain.responses.gradereport.user.AccessInformation;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.client.MoodleHttpClient;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.gradereport.user.AccessInformationDTO;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.mappers.gradereport.AccessInformationMapper;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class AccessInformationAdapter implements AccessInformationPort {

    private final MoodleHttpClient moodleHttpClient;
    private final AccessInformationMapper responseMapper;

    private static final String GRADEREPORT_USER_GET_ACCESS_INFORMATION = "gradereport_user_get_access_information";

    @Override
    public AccessInformation getAccessInformation(Long courseId) {
        Map<String, Object> params = new HashMap<>();
        params.put("courseid", courseId.toString());
        AccessInformationDTO responseDto = moodleHttpClient.call(GRADEREPORT_USER_GET_ACCESS_INFORMATION, params, AccessInformationDTO.class);
        if (responseDto == null) {
            return AccessInformation.builder()
                    .warnings(java.util.Collections.emptyList())
                    .build();
        }
        return responseMapper.toDomain(responseDto);
    }
}
