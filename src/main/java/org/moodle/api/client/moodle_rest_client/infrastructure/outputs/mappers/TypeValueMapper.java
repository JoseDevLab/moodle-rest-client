package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.mappers;

import org.mapstruct.Mapper;
import org.moodle.api.client.moodle_rest_client.domain.requests.TypeValueRequest;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.TypeValueRequestDTO;

import java.util.List;

@Mapper
public interface TypeValueMapper {
    TypeValueRequestDTO toRequestDTO(TypeValueRequest request);
    List<TypeValueRequestDTO> toRequestDTO(List<TypeValueRequest> requests);
}
