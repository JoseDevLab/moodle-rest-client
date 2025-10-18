package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.course.course;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeleteCourseRequestDTO {
    private Long courseid;
}
