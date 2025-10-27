package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.reportbuilder.retrieveSystemReport;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.moodle.api.client.moodle_rest_client.domain.requests.reportbuilder.ContextRequest;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RetrieveSystemReportRequestDTO {
    private String source;
    private ContextRequest context;
    private String component;
    private String area;
    private Long itemid;
    private List<ParameterRequestDTO> parameters;
    private Integer page;
    private Integer perpage;
}
