package org.moodle.api.client.moodle_rest_client.domain.ports.in.course.course;

import org.moodle.api.client.moodle_rest_client.domain.exceptions.MoodleApiException;
import org.moodle.api.client.moodle_rest_client.domain.responses.course.category.CourseSearch;
import org.moodle.api.client.moodle_rest_client.domain.models.MoodleCredentials;

public interface SearchCoursesUseCase {
    CourseSearch searchCourses(MoodleCredentials moodleCredentials, String searchText, int page, int perPage) throws MoodleApiException;
}
