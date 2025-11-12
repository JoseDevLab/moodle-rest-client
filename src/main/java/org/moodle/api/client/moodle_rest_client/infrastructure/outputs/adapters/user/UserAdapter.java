package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.adapters.user;

import lombok.RequiredArgsConstructor;
import org.moodle.api.client.moodle_rest_client.domain.exceptions.MoodleApiException;
import org.moodle.api.client.moodle_rest_client.domain.models.Warning;
import org.moodle.api.client.moodle_rest_client.domain.ports.out.user.UserPort;
import org.moodle.api.client.moodle_rest_client.domain.requests.user.CreateUserRequest;
import org.moodle.api.client.moodle_rest_client.domain.requests.user.SearchUserCriterion;
import org.moodle.api.client.moodle_rest_client.domain.requests.user.UpdateUserRequest;
import org.moodle.api.client.moodle_rest_client.domain.responses.user.CreateUserResponse;
import org.moodle.api.client.moodle_rest_client.domain.responses.user.UserSearchResponse;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.client.MoodleHttpClient;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.user.*;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.mappers.WarningMapper;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.mappers.user.UserMapper;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.mappers.user.UserSearchResponseMapper;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@RequiredArgsConstructor
public class UserAdapter implements UserPort {

    private final MoodleHttpClient moodleHttpClient;
    private final UserMapper userMapper;
    private final WarningMapper warningMapper;
    private final UserSearchResponseMapper responseMapper;

    private static final String GET_USERS_FUNCTION = "core_user_get_users";
    private static final String CREATE_USERS_FUNCTION = "core_user_create_users";
    private static final String UPDATE_USERS_FUNCTION = "core_user_update_users";

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

        return userMapper.toCreateResponseDomain(Arrays.asList(responseArray));
    }

    @Override
    public List<Warning> updateUsers(List<UpdateUserRequest> usersToUpdate) throws MoodleApiException {
        List<UpdateUserRequestDTO> dtoList = userMapper.toUpdateRequestDTO(usersToUpdate);

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("users", dtoList);

        UpdateUsersResponseDTO responseDto = moodleHttpClient.call(
                UPDATE_USERS_FUNCTION,
                requestBody,
                UpdateUsersResponseDTO.class
        );

        if (responseDto == null) {
            return Collections.emptyList();
        }

        return warningMapper.toDomain(responseDto.getWarnings());
    }
}