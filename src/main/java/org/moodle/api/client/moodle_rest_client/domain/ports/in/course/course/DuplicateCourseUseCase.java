package org.moodle.api.client.moodle_rest_client.domain.ports.in.course.course;

import org.moodle.api.client.moodle_rest_client.domain.exceptions.MoodleApiException;
import org.moodle.api.client.moodle_rest_client.domain.models.Course;
import org.moodle.api.client.moodle_rest_client.domain.requests.course.course.DuplicateCourseRequest;
import org.moodle.api.client.moodle_rest_client.domain.models.MoodleCredentials;

public interface DuplicateCourseUseCase {
    Course duplicateCourse(MoodleCredentials moodleCredentials, DuplicateCourseRequest request) throws MoodleApiException;
}
