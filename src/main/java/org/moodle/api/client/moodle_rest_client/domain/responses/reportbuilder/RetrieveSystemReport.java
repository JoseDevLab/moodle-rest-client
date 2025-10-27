package org.moodle.api.client.moodle_rest_client.domain.responses.reportbuilder;

import lombok.Builder;
import lombok.Data;
import org.moodle.api.client.moodle_rest_client.domain.models.Warning;

import java.util.List;

@Data
@Builder
public class RetrieveSystemReport {
    private RetrieveSystemReportData data;
    private List<Warning> warnings;
}
