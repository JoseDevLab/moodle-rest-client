package org.moodle.api.client.moodle_rest_client.domain.ports.in.course.course;

import org.moodle.api.client.moodle_rest_client.domain.exceptions.MoodleApiException;
import org.moodle.api.client.moodle_rest_client.domain.models.Course;

import java.util.List;

public interface GetCoursesByIdUseCase {
    List<Course> getCoursesById(List<Long> courseIds) throws MoodleApiException;
}
