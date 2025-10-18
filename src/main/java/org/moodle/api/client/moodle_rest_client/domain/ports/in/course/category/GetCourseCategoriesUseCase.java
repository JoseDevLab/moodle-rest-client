package org.moodle.api.client.moodle_rest_client.domain.ports.in.course.category;

import org.moodle.api.client.moodle_rest_client.domain.exceptions.MoodleApiException;
import org.moodle.api.client.moodle_rest_client.domain.models.Category;

import java.util.List;

public interface GetCourseCategoriesUseCase {
    List<Category> getCourseCategories() throws MoodleApiException;
}
