package org.moodle.api.client.moodle_rest_client.domain.requests.reportbuilder;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ParameterRequest {
    private String name;
    private String value;
}
