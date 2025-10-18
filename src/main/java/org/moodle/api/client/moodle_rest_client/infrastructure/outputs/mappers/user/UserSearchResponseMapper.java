package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.mappers.user;

import org.mapstruct.Mapper;
import org.moodle.api.client.moodle_rest_client.domain.responses.user.UserSearchResponse;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.user.UserSearchResponseDTO;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.mappers.WarningMapper;

@Mapper(uses = {UserMapper.class, WarningMapper.class})
public interface UserSearchResponseMapper {
    UserSearchResponse toDomain(UserSearchResponseDTO dto);
}