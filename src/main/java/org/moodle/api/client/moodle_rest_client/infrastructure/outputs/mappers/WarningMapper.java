package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.mappers;

import org.mapstruct.Mapper;
import org.moodle.api.client.moodle_rest_client.domain.models.Warning;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.WarningDTO;

import java.util.List;

@Mapper
public interface WarningMapper {
    Warning toDomain(WarningDTO dto);
    List<Warning> toDomain(List<WarningDTO> dtos);
}
