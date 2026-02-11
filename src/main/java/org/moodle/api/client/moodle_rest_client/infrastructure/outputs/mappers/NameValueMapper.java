package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.mappers;

import org.mapstruct.Mapper;
import org.moodle.api.client.moodle_rest_client.domain.requests.NameValueRequest;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.NameValueRequestDTO;

import java.util.List;

@Mapper
public interface NameValueMapper {
    NameValueRequestDTO toRequestDTO(NameValueRequest request);
    List<NameValueRequestDTO> toRequestDTO(List<NameValueRequest> requests);
}
