package org.moodle.api.client.moodle_rest_client.domain.ports.in.course.course;

import org.moodle.api.client.moodle_rest_client.domain.exceptions.MoodleApiException;
import org.moodle.api.client.moodle_rest_client.domain.models.Course;
import org.moodle.api.client.moodle_rest_client.domain.requests.course.course.CreateCourseRequest;
import org.moodle.api.client.moodle_rest_client.domain.models.MoodleCredentials;

import java.util.List;

public interface CreateCoursesUseCase {
    List<Course> createCourses(MoodleCredentials moodleCredentials, List<CreateCourseRequest> coursesToCreate) throws MoodleApiException;
}
