package org.moodle.api.client.moodle_rest_client.domain.responses.reportbuilder;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RetrieveSystemReportData {
    private List<String> headers;
    private List<Row> rows;
    private Integer totalrowcount;
}
