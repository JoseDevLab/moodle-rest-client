package org.moodle.api.client.moodle_rest_client.domain.ports.in.course.category;

import org.moodle.api.client.moodle_rest_client.domain.exceptions.MoodleApiException;
import org.moodle.api.client.moodle_rest_client.domain.requests.course.category.DeleteCategoryRequest;
import org.moodle.api.client.moodle_rest_client.domain.models.MoodleCredentials;

import java.util.List;

public interface DeleteCategoriesUseCase {
    void deleteCategories(MoodleCredentials moodleCredentials, List<DeleteCategoryRequest> categoriesToDelete) throws MoodleApiException;
}
