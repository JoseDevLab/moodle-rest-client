package org.moodle.api.client.moodle_rest_client.domain.ports.in.course.category;

import org.moodle.api.client.moodle_rest_client.domain.exceptions.MoodleApiException;
import org.moodle.api.client.moodle_rest_client.domain.requests.course.category.SearchCategoryRequest;
import org.moodle.api.client.moodle_rest_client.domain.responses.course.category.RecursiveCategory;
import org.moodle.api.client.moodle_rest_client.domain.models.MoodleCredentials;

import java.util.List;

public interface GetRecursiveCategoriesUseCase {
    List<RecursiveCategory> getRecursiveCategories(MoodleCredentials moodleCredentials, SearchCategoryRequest request) throws MoodleApiException;
}
