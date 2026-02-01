package org.moodle.api.client.moodle_rest_client.domain.ports.in.gradereport.overview;

import org.moodle.api.client.moodle_rest_client.domain.exceptions.MoodleApiException;
import org.moodle.api.client.moodle_rest_client.domain.models.MoodleCredentials;
import org.moodle.api.client.moodle_rest_client.domain.responses.gradereport.overview.CourseGrades;

public interface GetCourseGradesUseCase {
    CourseGrades getCourseGrades(MoodleCredentials moodleCredentials, Long userId) throws MoodleApiException;
}