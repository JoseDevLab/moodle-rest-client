package org.moodle.api.client.moodle_rest_client.domain.ports.in.course.course;

import org.moodle.api.client.moodle_rest_client.domain.exceptions.MoodleApiException;

import java.util.List;

public interface DeleteCoursesUseCase {
    void deleteCourses(List<Long> courseIds) throws MoodleApiException;
}
