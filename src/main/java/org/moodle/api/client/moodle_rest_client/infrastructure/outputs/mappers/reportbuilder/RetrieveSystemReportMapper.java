package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.mappers.reportbuilder;

import org.mapstruct.Mapper;
import org.moodle.api.client.moodle_rest_client.domain.requests.reportbuilder.ContextRequest;
import org.moodle.api.client.moodle_rest_client.domain.requests.reportbuilder.ParameterRequest;
import org.moodle.api.client.moodle_rest_client.domain.requests.reportbuilder.RetrieveSystemReportRequest;
import org.moodle.api.client.moodle_rest_client.domain.responses.reportbuilder.RetrieveSystemReport;
import org.moodle.api.client.moodle_rest_client.domain.responses.reportbuilder.RetrieveSystemReportData;
import org.moodle.api.client.moodle_rest_client.domain.responses.reportbuilder.Row;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.reportbuilder.retrieveSystemReport.*;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.mappers.WarningMapper;

import java.util.List;

@Mapper(uses = WarningMapper.class)
public interface RetrieveSystemReportMapper {
    Row toDomain(RowDTO dto);
    List<Row> toRowsDomain(List<RowDTO> dtos);
    RetrieveSystemReportData toDomain(RetrieveSystemReportDataDTO dto);
    RetrieveSystemReport toDomain(RetrieveSystemReportDTO dto);
    ContextRequestDTO toDto(ContextRequest entity);
    ParameterRequestDTO toDto(ParameterRequest entity);
    List<ParameterRequestDTO> toParametersDto(List<ParameterRequestDTO> dtos);
    RetrieveSystemReportRequestDTO toDto(RetrieveSystemReportRequest dto);
}
