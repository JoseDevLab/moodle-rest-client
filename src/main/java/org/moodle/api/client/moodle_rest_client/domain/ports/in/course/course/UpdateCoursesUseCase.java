package org.moodle.api.client.moodle_rest_client.domain.ports.in.course.course;

import org.moodle.api.client.moodle_rest_client.domain.exceptions.MoodleApiException;
import org.moodle.api.client.moodle_rest_client.domain.requests.course.course.UpdateCourseRequest;
import org.moodle.api.client.moodle_rest_client.domain.models.MoodleCredentials;

import java.util.List;

public interface UpdateCoursesUseCase {
    void updateCourses(MoodleCredentials moodleCredentials, List<UpdateCourseRequest> coursesToUpdate) throws MoodleApiException;
}
