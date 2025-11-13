package org.moodle.api.client.moodle_rest_client.domain.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CourseGrade {
    private Long courseId;
    private String grade;
    private String rawGrade;
    private Integer rank;
}