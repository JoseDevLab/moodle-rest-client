package org.moodle.api.client.moodle_rest_client.domain.ports.in.course.course;

import org.moodle.api.client.moodle_rest_client.domain.exceptions.MoodleApiException;
import org.moodle.api.client.moodle_rest_client.domain.models.Course;
import org.moodle.api.client.moodle_rest_client.domain.requests.course.course.DuplicateCourseRequest;

public interface DuplicateCourseUseCase {
    Course duplicateCourse(DuplicateCourseRequest request) throws MoodleApiException;
}
