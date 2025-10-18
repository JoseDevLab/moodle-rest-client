package org.moodle.api.client.moodle_rest_client.domain.ports.in.course.course;

import org.moodle.api.client.moodle_rest_client.domain.exceptions.MoodleApiException;
import org.moodle.api.client.moodle_rest_client.domain.models.Course;
import org.moodle.api.client.moodle_rest_client.domain.requests.course.course.CreateCourseRequest;

import java.util.List;

public interface CreateCoursesUseCase {
    List<Course> createCourses(List<CreateCourseRequest> coursesToCreate) throws MoodleApiException;
}
