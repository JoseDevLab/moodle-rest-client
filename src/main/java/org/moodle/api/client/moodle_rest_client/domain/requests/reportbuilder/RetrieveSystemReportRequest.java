package org.moodle.api.client.moodle_rest_client.domain.requests.reportbuilder;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RetrieveSystemReportRequest {
    private String source;
    private ContextRequest context;
    private String component;
    private String area;
    private Long itemid;
    private List<ParameterRequest> parameters;
    private Integer page;
    private Integer perpage;
}
