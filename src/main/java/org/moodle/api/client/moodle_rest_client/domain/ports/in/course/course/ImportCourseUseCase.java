package org.moodle.api.client.moodle_rest_client.domain.ports.in.course.course;

import org.moodle.api.client.moodle_rest_client.domain.exceptions.MoodleApiException;
import org.moodle.api.client.moodle_rest_client.domain.requests.course.course.ImportCourseRequest;

public interface ImportCourseUseCase {
    void importCourse(ImportCourseRequest request) throws MoodleApiException;
}
