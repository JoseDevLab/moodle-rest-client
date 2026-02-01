package org.moodle.api.client.moodle_rest_client.domain.ports.in.course.category;

import org.moodle.api.client.moodle_rest_client.domain.exceptions.MoodleApiException;
import org.moodle.api.client.moodle_rest_client.domain.requests.course.category.RecursiveCategoryRequest;
import org.moodle.api.client.moodle_rest_client.domain.responses.course.category.BulkCategoryCreation;
import org.moodle.api.client.moodle_rest_client.domain.models.MoodleCredentials;

import java.util.List;

public interface BulkCreateCategoriesUseCase {
    BulkCategoryCreation createCategoryTree(MoodleCredentials moodleCredentials, List<RecursiveCategoryRequest> categoryTree) throws MoodleApiException;
}
