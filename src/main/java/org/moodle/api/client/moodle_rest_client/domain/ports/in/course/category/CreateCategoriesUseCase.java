package org.moodle.api.client.moodle_rest_client.domain.ports.in.course.category;

import org.moodle.api.client.moodle_rest_client.domain.exceptions.MoodleApiException;
import org.moodle.api.client.moodle_rest_client.domain.models.Category;
import org.moodle.api.client.moodle_rest_client.domain.requests.course.category.CreateCategoryRequest;
import org.moodle.api.client.moodle_rest_client.domain.models.MoodleCredentials;

import java.util.List;

public interface CreateCategoriesUseCase {
    List<Category> createCategories(MoodleCredentials moodleCredentials, List<CreateCategoryRequest> categoriesToCreate) throws MoodleApiException;
}
