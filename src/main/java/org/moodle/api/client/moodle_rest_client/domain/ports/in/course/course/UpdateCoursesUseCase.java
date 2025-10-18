package org.moodle.api.client.moodle_rest_client.domain.ports.in.course.course;

import org.moodle.api.client.moodle_rest_client.domain.exceptions.MoodleApiException;
import org.moodle.api.client.moodle_rest_client.domain.requests.course.course.UpdateCourseRequest;

import java.util.List;

public interface UpdateCoursesUseCase {
    void updateCourses(List<UpdateCourseRequest> coursesToUpdate) throws MoodleApiException;
}
