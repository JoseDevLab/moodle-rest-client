package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.reportbuilder.retrieveSystemReport;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RowDTO {
    private List<String> columns;
}
