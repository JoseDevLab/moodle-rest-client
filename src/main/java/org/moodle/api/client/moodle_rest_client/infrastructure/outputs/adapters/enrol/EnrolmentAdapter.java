package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.adapters.enrol;

import lombok.RequiredArgsConstructor;
import org.moodle.api.client.moodle_rest_client.domain.models.EnrolledUser;
import org.moodle.api.client.moodle_rest_client.domain.ports.out.enrol.EnrolmentPort;
import org.moodle.api.client.moodle_rest_client.domain.requests.enrol.EnrolUserRequest;
import org.moodle.api.client.moodle_rest_client.domain.requests.enrol.GetEnrolledUsersOption;
import org.moodle.api.client.moodle_rest_client.domain.requests.enrol.UnenrolUserRequest;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.client.MoodleHttpClient;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.enrol.EnrolUserRequestDTO;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.enrol.EnrolledUserDTO;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.enrol.GetEnrolledUsersOptionDTO;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.enrol.UnenrolUserRequestDTO;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.mappers.enrol.EnrolmentMapper;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class EnrolmentAdapter implements EnrolmentPort {

    private final MoodleHttpClient moodleHttpClient;
    private final EnrolmentMapper enrolmentMapper;

    private static final String ENROL_USERS_FUNCTION = "enrol_manual_enrol_users";
    private static final String UNENROL_USERS_FUNCTION = "enrol_manual_unenrol_users";
    private static final String GET_ENROLLED_USERS_FUNCTION = "core_enrol_get_enrolled_users";

    @Override
    public void enrolUsers(List<EnrolUserRequest> enrolments) {
        List<EnrolUserRequestDTO> dtoList = enrolmentMapper.toRequestDTO(enrolments);

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("enrolments", dtoList);

        // Este endpoint no devuelve datos, solo null o lanza excepción
        moodleHttpClient.call(ENROL_USERS_FUNCTION, requestBody, Void.class);
    }

    @Override
    public void unenrolUsers(List<UnenrolUserRequest> enrolments) {
        List<UnenrolUserRequestDTO> dtoList = enrolmentMapper.toUnenrolRequestDTO(enrolments);

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("enrolments", dtoList);

        // Este endpoint no devuelve datos, solo null o lanza excepción
        moodleHttpClient.call(UNENROL_USERS_FUNCTION, requestBody, Void.class);
    }

    @Override
    public List<EnrolledUser> getEnrolledUsers(Integer courseid, List<GetEnrolledUsersOption> options) {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("courseid", courseid);

        if (options != null && !options.isEmpty()) {
            List<GetEnrolledUsersOptionDTO> dtoList = enrolmentMapper.toOptionRequestDTO(options);
            requestBody.put("options", dtoList);
        }

        EnrolledUserDTO[] responseArray = moodleHttpClient.call(
            GET_ENROLLED_USERS_FUNCTION, 
            requestBody, 
            EnrolledUserDTO[].class
        );

        if (responseArray == null) {
            return Collections.emptyList();
        }

        return enrolmentMapper.toEnrolledUserDomain(java.util.Arrays.asList(responseArray));
    }

    @Override
    public List<EnrolledUser> getEnrolledUsers(Integer courseid) {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("courseid", courseid);

        EnrolledUserDTO[] responseArray = moodleHttpClient.call(
            GET_ENROLLED_USERS_FUNCTION,
            requestBody,
            EnrolledUserDTO[].class
        );

        if (responseArray == null) {
            return Collections.emptyList();
        }

        return enrolmentMapper.toEnrolledUserDomain(java.util.Arrays.asList(responseArray));
    }
}
