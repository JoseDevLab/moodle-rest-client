package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.mappers.gradereport;

import org.mapstruct.Mapper;
import org.moodle.api.client.moodle_rest_client.domain.responses.gradereport.user.AccessInformation;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.gradereport.user.AccessInformationDTO;

@Mapper
public interface AccessInformationMapper {
    AccessInformation toDomain(AccessInformationDTO dto);
}
