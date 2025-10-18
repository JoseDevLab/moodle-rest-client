package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.mappers;

import org.mapstruct.Mapper;
import org.moodle.api.client.moodle_rest_client.domain.models.Warning;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.WarningDTO;

@Mapper
public interface WarningMapper {
    Warning toDomain(WarningDTO dto);
}
