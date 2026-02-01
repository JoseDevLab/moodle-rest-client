package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.adapters.reportbuilder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.moodle.api.client.moodle_rest_client.domain.exceptions.MoodleApiException;
import org.moodle.api.client.moodle_rest_client.domain.models.MoodleCredentials;
import org.moodle.api.client.moodle_rest_client.domain.ports.out.reportbuilder.RetrieveSystemReportPort;
import org.moodle.api.client.moodle_rest_client.domain.requests.reportbuilder.RetrieveSystemReportRequest;
import org.moodle.api.client.moodle_rest_client.domain.responses.reportbuilder.RetrieveSystemReport;
import org.moodle.api.client.moodle_rest_client.domain.responses.reportbuilder.RetrieveSystemReportData;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.client.MoodleHttpClient;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.reportbuilder.retrieveSystemReport.RetrieveSystemReportDTO;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.reportbuilder.retrieveSystemReport.RetrieveSystemReportRequestDTO;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.mappers.MoodleCredentialsMapper;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.mappers.reportbuilder.RetrieveSystemReportMapper;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;



@Component
@RequiredArgsConstructor
public class RetrieveSystemReportAdapter implements RetrieveSystemReportPort {

    private final ObjectMapper objectMapper;
    private final MoodleHttpClient moodleHttpClient;
    private final RetrieveSystemReportMapper retrieveSystemReportMapper;
    private final MoodleCredentialsMapper moodleCredentialsMapper;

    private static final String CORE_REPORTBUILDER_RETRIEVE_SYSTEM_REPORT = "core_reportbuilder_retrieve_system_report";

    @Override
    public RetrieveSystemReport execute(MoodleCredentials moodleCredentials, RetrieveSystemReportRequest request) throws MoodleApiException {
        RetrieveSystemReportRequestDTO requestDTO = retrieveSystemReportMapper.toDto(request);
        Map<String, Object> requestBody = objectMapper.convertValue(requestDTO, new TypeReference<Map<String, Object>>() {});
        RetrieveSystemReportDTO dto = moodleHttpClient.call(
                moodleCredentialsMapper.toDTO(moodleCredentials),
                CORE_REPORTBUILDER_RETRIEVE_SYSTEM_REPORT,
                requestBody,
                RetrieveSystemReportDTO.class
        );
        if (dto == null) {
            return RetrieveSystemReport.builder()
                    .data(RetrieveSystemReportData.builder()
                            .headers(Collections.emptyList())
                            .rows(Collections.emptyList())
                            .build())
                    .warnings(Collections.emptyList())
                    .build();
        }
        return retrieveSystemReportMapper.toDomain(dto);
    }
}
