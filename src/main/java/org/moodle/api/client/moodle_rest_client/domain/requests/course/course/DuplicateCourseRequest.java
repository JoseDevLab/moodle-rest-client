package org.moodle.api.client.moodle_rest_client.domain.requests.course.course;

import lombok.Builder;
import lombok.Data;
import org.moodle.api.client.moodle_rest_client.domain.requests.NameValueRequest;

import java.util.List;

@Data
@Builder
public class DuplicateCourseRequest {
    private Long courseid;
    private String fullname;
    private String shortname;
    private Long categoryid;
    private Boolean visible;
    private List<NameValueRequest> options;
}
