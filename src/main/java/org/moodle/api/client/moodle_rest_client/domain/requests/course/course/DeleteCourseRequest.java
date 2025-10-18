package org.moodle.api.client.moodle_rest_client.domain.requests.course.course;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeleteCourseRequest {
    private Long courseid;
}
