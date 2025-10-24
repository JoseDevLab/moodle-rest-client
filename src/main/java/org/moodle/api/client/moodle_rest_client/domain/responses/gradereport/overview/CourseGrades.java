package org.moodle.api.client.moodle_rest_client.domain.responses.gradereport.overview;

import lombok.Builder;
import lombok.Data;
import org.moodle.api.client.moodle_rest_client.domain.models.CourseGrade;
import org.moodle.api.client.moodle_rest_client.domain.models.Warning;

import java.util.List;

@Data
@Builder
public class CourseGrades {
    private List<CourseGrade> grades;
    private List<Warning> warnings;
}