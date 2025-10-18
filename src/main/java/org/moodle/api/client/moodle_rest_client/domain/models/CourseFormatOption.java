package org.moodle.api.client.moodle_rest_client.domain.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CourseFormatOption {
    private String name;
    private String value;
}
