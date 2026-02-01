package org.moodle.api.client.moodle_rest_client.domain.ports.in.course.course;

import org.moodle.api.client.moodle_rest_client.domain.exceptions.MoodleApiException;
import org.moodle.api.client.moodle_rest_client.domain.models.Course;
import org.moodle.api.client.moodle_rest_client.domain.models.MoodleCredentials;

import java.util.List;

public interface GetCoursesByFieldUseCase {
    List<Course> getCoursesByField(MoodleCredentials moodleCredentials, String field, String value) throws MoodleApiException;
}
