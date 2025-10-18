package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.mappers.user;

import org.mapstruct.Mapper;
import org.moodle.api.client.moodle_rest_client.domain.models.User;
import org.moodle.api.client.moodle_rest_client.domain.models.UserCustomField;
import org.moodle.api.client.moodle_rest_client.domain.models.UserPreference;
import org.moodle.api.client.moodle_rest_client.domain.requests.user.CreateUserRequest;
import org.moodle.api.client.moodle_rest_client.domain.requests.user.SearchUserCriterion;
import org.moodle.api.client.moodle_rest_client.domain.responses.user.CreateUserResponse;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.user.*;

import java.util.List;

@Mapper
public interface UserMapper {
    // Mapeo para get users
    User toDomain(UserDTO dto);
    List<User> toDomain(List<UserDTO> dtos);

    UserCustomField toDomain(UserCustomFieldDTO dto);
    UserPreference toDomain(UserPreferenceDTO dto);

    SearchUserCriterionDTO toRequestDTO(SearchUserCriterion criterion);
    List<SearchUserCriterionDTO> toRequestDTO(List<SearchUserCriterion> criteria);

    // Mapeo para create users
    CreateUserRequestDTO toRequestDTO(CreateUserRequest request);
    List<CreateUserRequestDTO> toCreateRequestDTO(List<CreateUserRequest> requests);

    UserCustomFieldDTO toDTO(UserCustomField customField);
    UserPreferenceDTO toDTO(UserPreference preference);

    CreateUserResponse toDomain(CreateUserResponseDTO dto);
    List<CreateUserResponse> toCreateResponseDomain(List<CreateUserResponseDTO> dtos);
}