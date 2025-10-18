package org.moodle.api.client.moodle_rest_client.domain.ports.in.course.course;

import org.moodle.api.client.moodle_rest_client.domain.exceptions.MoodleApiException;
import org.moodle.api.client.moodle_rest_client.domain.models.CourseModule;

public interface GetCourseModuleUseCase {
    CourseModule getCourseModule(Long courseModuleId) throws MoodleApiException;
}
