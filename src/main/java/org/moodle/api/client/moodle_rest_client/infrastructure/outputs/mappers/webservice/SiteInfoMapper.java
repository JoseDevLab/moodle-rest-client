package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.mappers.webservice;

import org.mapstruct.Mapper;
import org.moodle.api.client.moodle_rest_client.domain.models.SiteInfo;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.webservice.SiteInfoDTO;

import java.util.List;

@Mapper(uses = {FunctionMapper.class, AdvancedFeatureMapper.class})
public interface SiteInfoMapper {
    SiteInfo toDomain(SiteInfoDTO dto);
    List<SiteInfo> toDomain(List<SiteInfoDTO> dtos);
}
