package org.moodle.api.client.moodle_rest_client.domain.requests.course.course;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DuplicateCourseRequest {
    private Long courseid;
    private String fullname;
    private String shortname;
    private Long categoryid;
    private boolean visible;
}
