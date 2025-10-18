package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.adapters.course;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.moodle.api.client.moodle_rest_client.domain.models.Category;
import org.moodle.api.client.moodle_rest_client.domain.ports.out.course.CategoryPort;
import org.moodle.api.client.moodle_rest_client.domain.requests.course.category.CreateCategoryRequest;
import org.moodle.api.client.moodle_rest_client.domain.requests.course.category.DeleteCategoryRequest;
import org.moodle.api.client.moodle_rest_client.domain.requests.course.category.SearchCategoryRequest;
import org.moodle.api.client.moodle_rest_client.domain.requests.course.category.UpdateCategoryRequest;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.client.MoodleHttpClient;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.course.category.*;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.mappers.course.CategoryMapper;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class CategoryAdapter implements CategoryPort {

    private final MoodleHttpClient moodleHttpClient;
    private final CategoryMapper categoryMapper;

    private static final String GET_CATEGORIES_FUNCTION = "core_course_get_categories";
    private static final String CREATE_CATEGORIES_FUNCTION = "core_course_create_categories";
    private static final String UPDATE_CATEGORIES_FUNCTION = "core_course_update_categories";
    private static final String DELETE_CATEGORIES_FUNCTION = "core_course_delete_categories";

    @Override
    public List<Category> getCourseCategories() {
        CategoryDTO[] categoryDTOS = moodleHttpClient.call(GET_CATEGORIES_FUNCTION, null, CategoryDTO[].class);
        if (categoryDTOS == null) {
            return Collections.emptyList();
        }
        return categoryMapper.toDomain(categoryDTOS);
    }

    @Override
    public List<Category> createCategories(List<CreateCategoryRequest> categoriesToCreate) {
        List<CreateCategoryRequestDTO> dtoList = categoryMapper.toRequestDTO(categoriesToCreate);
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("categories", dtoList);
        CategoryDTO[] createdCategories = moodleHttpClient.call(CREATE_CATEGORIES_FUNCTION, requestBody, CategoryDTO[].class);
        if (createdCategories == null) {
            return Collections.emptyList();
        }
        return categoryMapper.toDomain(createdCategories);
    }

    @Override
    public void updateCategories(List<UpdateCategoryRequest> categoriesToUpdate) {
        List<UpdateCategoryRequestDTO> dtoList = categoryMapper.toUpdateDTO(categoriesToUpdate);
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("categories", dtoList);
        moodleHttpClient.call(UPDATE_CATEGORIES_FUNCTION, requestBody, Void.class);
    }

    @Override
    public void deleteCategories(List<DeleteCategoryRequest> categoriesToDelete) {
        List<DeleteCategoryRequestDTO> dtoList = categoryMapper.toDeleteDTO(categoriesToDelete);
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("categories", dtoList);
        moodleHttpClient.call(DELETE_CATEGORIES_FUNCTION, requestBody, Void.class);
    }

    @Override
    public List<Category> searchCategories(SearchCategoryRequest searchCategoryRequest) {
        log.info("Searching categories with criteria: {}", searchCategoryRequest);
        SearchCategoryRequestDTO searchCategoryRequestDTO = categoryMapper.toRequestDTO(searchCategoryRequest);
        log.debug("Mapped criteria to DTOs: {}", searchCategoryRequestDTO);
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("addsubcategories", searchCategoryRequestDTO.getAddsubcategories());
        requestBody.put("criteria", searchCategoryRequestDTO.getCriteria());
        log.debug("Request body for search: {}", requestBody);
        CategoryDTO[] categoryDTOS = moodleHttpClient.call(GET_CATEGORIES_FUNCTION, requestBody, CategoryDTO[].class);
        log.info("Received {} category DTOs from Moodle", categoryDTOS != null ? categoryDTOS.length : 0);
        if (categoryDTOS == null) {
            return Collections.emptyList();
        }
        List<Category> categories = categoryMapper.toDomain(categoryDTOS);
        log.info("Mapped to {} domain categories", categories.size());
        return categories;
    }
}
