package org.moodle.api.client.moodle_rest_client.domain.ports.in.course.course;

import org.moodle.api.client.moodle_rest_client.domain.exceptions.MoodleApiException;
import org.moodle.api.client.moodle_rest_client.domain.responses.course.category.CourseSearch;

public interface SearchCoursesUseCase {
    CourseSearch searchCourses(String searchText, int page, int perPage) throws MoodleApiException;
}
