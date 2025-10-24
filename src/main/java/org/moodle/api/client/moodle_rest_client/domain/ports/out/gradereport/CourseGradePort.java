package org.moodle.api.client.moodle_rest_client.domain.ports.out.gradereport;

import org.moodle.api.client.moodle_rest_client.domain.exceptions.MoodleApiException;
import org.moodle.api.client.moodle_rest_client.domain.responses.gradereport.overview.CourseGrades;

public interface CourseGradePort {
    CourseGrades getCourseGrades(Integer userId) throws MoodleApiException;
}