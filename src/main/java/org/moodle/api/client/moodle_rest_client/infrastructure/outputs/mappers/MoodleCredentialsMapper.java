package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.moodle.api.client.moodle_rest_client.domain.models.MoodleCredentials;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.MoodleCredentialsDTO;

@Mapper
public interface MoodleCredentialsMapper {
    @Mapping(target = "url", source = "apiUrl")
    @Mapping(target = "wstoken", source = "apiToken")
    MoodleCredentialsDTO toDTO(MoodleCredentials credentials);
}
