package org.moodle.api.client.moodle_rest_client.domain.ports.out.course;

import org.moodle.api.client.moodle_rest_client.domain.exceptions.MoodleApiException;
import org.moodle.api.client.moodle_rest_client.domain.models.Category;
import org.moodle.api.client.moodle_rest_client.domain.requests.course.category.CreateCategoryRequest;
import org.moodle.api.client.moodle_rest_client.domain.requests.course.category.DeleteCategoryRequest;
import org.moodle.api.client.moodle_rest_client.domain.requests.course.category.SearchCategoryRequest;
import org.moodle.api.client.moodle_rest_client.domain.requests.course.category.UpdateCategoryRequest;
import org.moodle.api.client.moodle_rest_client.domain.models.MoodleCredentials;

import java.util.List;

public interface CategoryPort {
    List<Category> getCourseCategories(MoodleCredentials moodleCredentials) throws MoodleApiException;
    List<Category> createCategories(MoodleCredentials moodleCredentials, List<CreateCategoryRequest> categoriesToCreate) throws MoodleApiException;
    void updateCategories(MoodleCredentials moodleCredentials, List<UpdateCategoryRequest> categoriesToUpdate) throws MoodleApiException;
    void deleteCategories(MoodleCredentials moodleCredentials, List<DeleteCategoryRequest> categoriesToDelete) throws MoodleApiException;
    List<Category> searchCategories(MoodleCredentials moodleCredentials, SearchCategoryRequest criteria) throws MoodleApiException;
}
