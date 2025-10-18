package org.moodle.api.client.moodle_rest_client.domain.responses.course.course;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomField {
    private String name;
    private String shortName;
    private String type;
    private String valueRaw;
    private String value;
}
