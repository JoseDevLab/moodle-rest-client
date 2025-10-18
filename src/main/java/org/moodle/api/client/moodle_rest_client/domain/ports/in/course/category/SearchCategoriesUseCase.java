package org.moodle.api.client.moodle_rest_client.domain.ports.in.course.category;

import org.moodle.api.client.moodle_rest_client.domain.exceptions.MoodleApiException;
import org.moodle.api.client.moodle_rest_client.domain.models.Category;
import org.moodle.api.client.moodle_rest_client.domain.requests.course.category.SearchCategoryRequest;

import java.util.List;

public interface SearchCategoriesUseCase {
    List<Category> searchCategories(SearchCategoryRequest criteria) throws MoodleApiException;
}
