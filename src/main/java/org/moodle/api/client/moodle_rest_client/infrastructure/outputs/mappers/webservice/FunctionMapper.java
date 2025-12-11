package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.mappers.webservice;

import org.mapstruct.Mapper;
import org.moodle.api.client.moodle_rest_client.domain.models.Function;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.webservice.FunctionDTO;

import java.util.List;

@Mapper
public interface FunctionMapper {
    Function toDomain(FunctionDTO dto);
    List<Function> toDomain(List<FunctionDTO> dtos);
}
