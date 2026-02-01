package org.moodle.api.client.moodle_rest_client.domain.ports.in.course.course;

import org.moodle.api.client.moodle_rest_client.domain.exceptions.MoodleApiException;
import org.moodle.api.client.moodle_rest_client.domain.models.CourseModule;
import org.moodle.api.client.moodle_rest_client.domain.models.MoodleCredentials;

public interface GetCourseModuleUseCase {
    CourseModule getCourseModule(MoodleCredentials moodleCredentials, Long courseModuleId) throws MoodleApiException;
}
