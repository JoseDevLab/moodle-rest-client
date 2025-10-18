package org.moodle.api.client.moodle_rest_client.domain.responses.course.course;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CourseDate {
    private String label;
    private Integer timestamp;
    private Integer relativeto;
    private String dataid;
}