package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.mappers.webservice;

import org.mapstruct.Mapper;
import org.moodle.api.client.moodle_rest_client.domain.models.AdvancedFeature;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.webservice.AdvancedFeatureDTO;

import java.util.List;

@Mapper
public interface AdvancedFeatureMapper {
    AdvancedFeature toDomain(AdvancedFeatureDTO dto);
    List<AdvancedFeature> toDomain(List<AdvancedFeatureDTO> dtos);
}
