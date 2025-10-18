package org.moodle.api.client.moodle_rest_client.domain.ports.in.course.category;

import org.moodle.api.client.moodle_rest_client.domain.exceptions.MoodleApiException;
import org.moodle.api.client.moodle_rest_client.domain.requests.course.category.DeleteCategoryRequest;

import java.util.List;

public interface DeleteCategoriesUseCase {
    void deleteCategories(List<DeleteCategoryRequest> categoriesToDelete) throws MoodleApiException;
}
