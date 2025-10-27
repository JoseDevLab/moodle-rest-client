package org.moodle.api.client.moodle_rest_client.domain.requests.reportbuilder;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContextRequest {
    private Integer contextid;
    private String contextlevel;
    private Integer instanceid;
}
