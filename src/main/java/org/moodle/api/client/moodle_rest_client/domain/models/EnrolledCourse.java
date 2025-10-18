package org.moodle.api.client.moodle_rest_client.domain.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EnrolledCourse {
    private Integer id;
    private String fullname;
    private String shortname;
}
