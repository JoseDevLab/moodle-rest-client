package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.course.course;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class DuplicateCourseRequestDTO {
    private Long courseid;
    private String fullname;
    private String shortname;
    private Long categoryid;
    private boolean visible;
}
