package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.adapters.user;

import lombok.RequiredArgsConstructor;
import org.moodle.api.client.moodle_rest_client.domain.ports.out.user.UserPort;
import org.moodle.api.client.moodle_rest_client.domain.requests.user.CreateUserRequest;
import org.moodle.api.client.moodle_rest_client.domain.requests.user.SearchUserCriterion;
import org.moodle.api.client.moodle_rest_client.domain.responses.user.CreateUserResponse;
import org.moodle.api.client.moodle_rest_client.domain.responses.user.UserSearchResponse;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.client.MoodleHttpClient;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.user.CreateUserRequestDTO;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.user.CreateUserResponseDTO;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.user.SearchUserCriterionDTO;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.user.UserSearchResponseDTO;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.mappers.user.UserMapper;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.mappers.user.UserSearchResponseMapper;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class UserAdapter implements UserPort {

    private final MoodleHttpClient moodleHttpClient;
    private final UserMapper userMapper;
    private final UserSearchResponseMapper responseMapper;

    private static final String GET_USERS_FUNCTION = "core_user_get_users";
    private static final String CREATE_USERS_FUNCTION = "core_user_create_users";

    @Override
    public UserSearchResponse getUsers(List<SearchUserCriterion> criteria) {
        Map<String, Object> requestBody = new HashMap<>();

        if (criteria != null && !criteria.isEmpty()) {
            List<SearchUserCriterionDTO> dtoList = userMapper.toRequestDTO(criteria);
            requestBody.put("criteria", dtoList);
        }

        UserSearchResponseDTO responseDto = moodleHttpClient.call(
            GET_USERS_FUNCTION, 
            requestBody, 
            UserSearchResponseDTO.class
        );

        if (responseDto == null) {
            return UserSearchResponse.builder()
                    .users(Collections.emptyList())
                    .warnings(Collections.emptyList())
                    .build();
        }

        return responseMapper.toDomain(responseDto);
    }

    @Override
    public List<CreateUserResponse> createUsers(List<CreateUserRequest> usersToCreate) {
        List<CreateUserRequestDTO> dtoList = userMapper.toCreateRequestDTO(usersToCreate);

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("users", dtoList);

        CreateUserResponseDTO[] responseArray = moodleHttpClient.call(
            CREATE_USERS_FUNCTION, 
            requestBody, 
            CreateUserResponseDTO[].class
        );

        if (responseArray == null) {
            return Collections.emptyList();
        }

        return userMapper.toCreateResponseDomain(java.util.Arrays.asList(responseArray));
    }
}