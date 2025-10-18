package org.moodle.api.client.moodle_rest_client.domain.responses.course.category;

import lombok.Builder;
import lombok.Data;
import org.moodle.api.client.moodle_rest_client.domain.models.Course;

import java.util.List;

@Data
@Builder
public class CourseSearch {
    private List<Course> courses;
    private int total;
}
