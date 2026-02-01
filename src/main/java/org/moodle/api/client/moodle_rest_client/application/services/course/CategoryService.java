package org.moodle.api.client.moodle_rest_client.application.services.course;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.moodle.api.client.moodle_rest_client.domain.exceptions.MoodleApiException;
import org.moodle.api.client.moodle_rest_client.domain.models.Category;
import org.moodle.api.client.moodle_rest_client.domain.models.MoodleCredentials;
import org.moodle.api.client.moodle_rest_client.domain.ports.in.course.category.*;
import org.moodle.api.client.moodle_rest_client.domain.ports.out.course.CategoryPort;
import org.moodle.api.client.moodle_rest_client.domain.requests.course.category.*;
import org.moodle.api.client.moodle_rest_client.domain.responses.course.category.BulkCategoryCreation;
import org.moodle.api.client.moodle_rest_client.domain.responses.course.category.FailedCategoryCreation;
import org.moodle.api.client.moodle_rest_client.domain.responses.course.category.RecursiveCategory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryService implements GetCourseCategoriesUseCase, CreateCategoriesUseCase, UpdateCategoriesUseCase,
        DeleteCategoriesUseCase, SearchCategoriesUseCase, BulkCreateCategoriesUseCase, GetRecursiveCategoriesUseCase {

    private final CategoryPort categoryPort;

    @Override
    public List<Category> getCourseCategories(MoodleCredentials moodleCredentials) {
        return categoryPort.getCourseCategories(moodleCredentials);
    }

    @Override
    public List<Category> createCategories(MoodleCredentials moodleCredentials, List<CreateCategoryRequest> categoriesToCreate) {
        return categoryPort.createCategories(moodleCredentials, categoriesToCreate);
    }

    @Override
    public void updateCategories(MoodleCredentials moodleCredentials, List<UpdateCategoryRequest> categoriesToUpdate) {
        categoryPort.updateCategories(moodleCredentials, categoriesToUpdate);
    }

    @Override
    public void deleteCategories(MoodleCredentials moodleCredentials, List<DeleteCategoryRequest> categoriesToDelete) {
        categoryPort.deleteCategories(moodleCredentials, categoriesToDelete);
    }

    @Override
    public List<Category> searchCategories(MoodleCredentials moodleCredentials, SearchCategoryRequest request) {
        return categoryPort.searchCategories(moodleCredentials, request);
    }

    @Override
    public BulkCategoryCreation createCategoryTree(MoodleCredentials moodleCredentials, List<RecursiveCategoryRequest> categoryTree) {
        BulkCategoryCreation response = new BulkCategoryCreation(new ArrayList<>(), new ArrayList<>());
        processLevel(moodleCredentials, categoryTree, 0L, response);
        return response;
    }

    private void processLevel(MoodleCredentials moodleCredentials, List<RecursiveCategoryRequest> requests, Long parentId, BulkCategoryCreation response) {
        if (requests == null || requests.isEmpty()) {
            return;
        }

        for (RecursiveCategoryRequest request : requests) {
            Long newParentId = null;
            try {
                // 1. Validar si la categoría ya existe
                List<SearchCriterion> criteria = new ArrayList<>();
                criteria.add(SearchCriterion.builder().key("name").value(request.getName()).build());
                criteria.add(SearchCriterion.builder().key("parent").value(parentId.toString()).build());
                SearchCategoryRequest searchCategoryRequest = SearchCategoryRequest.builder()
                        .addSubCategories(false)
                        .criteria(criteria)
                        .build();
                log.info("Criterios de busqueda: {}", searchCategoryRequest);
                List<Category> existingCategories = this.searchCategories(moodleCredentials, searchCategoryRequest);
                log.info("Categorias encontradas: {}", existingCategories);
                Category processedCategory;
                if (!existingCategories.isEmpty()) {
                    if (existingCategories.size() > 1) {
                        throw new MoodleApiException("Ambigüedad detectada: Se encontraron " + existingCategories.size() + " categorías con el nombre '" + request.getName() + "' bajo el mismo padre.");
                    }
                    // 2a. La categoría ya existe, la usamos
                    processedCategory = existingCategories.get(0);
                } else {
                    // 2b. La categoría no existe, la creamos
                    CreateCategoryRequest createRequest = CreateCategoryRequest.builder()
                            .name(request.getName())
                            .parent(parentId)
                            .idnumber(request.getIdnumber())
                            .description(request.getDescription())
                            .descriptionFormat(request.getDescriptionformat())
                            .theme(request.getTheme())
                            .build();
                    log.info("Creando categoría: {}", createRequest);
                    this.createCategories(moodleCredentials, Collections.singletonList(createRequest));
                    List<Category> created = this.searchCategories(moodleCredentials, searchCategoryRequest);
                    processedCategory = created.get(0);
                }

                response.getSuccessfulCategories().add(processedCategory);
                newParentId = processedCategory.getId();

            } catch (MoodleApiException e) {
                response.getFailedCreations().add(new FailedCategoryCreation(request, e, e.getMessage()));
            } catch (Exception e) {
                response.getFailedCreations().add(new FailedCategoryCreation(request, e, "Error inesperado: " + e.getMessage()));
            }

            // 3. Si la operación fue exitosa y hay hijos, procesar el siguiente nivel
            if (newParentId != null) {
                processLevel(moodleCredentials, request.getChildren(), newParentId, response);
            }
        }
    }

    @Override
    public List<RecursiveCategory> getRecursiveCategories(MoodleCredentials moodleCredentials, SearchCategoryRequest request) throws MoodleApiException {
        List<Category> categories = categoryPort.searchCategories(moodleCredentials, request);

        // Crear un mapa para acceso rápido por ID
        Map<Long, RecursiveCategory> categoryMap = categories.stream()
                .collect(Collectors.toMap(Category::getId, category -> RecursiveCategory.builder()
                        .id(category.getId())
                        .name(category.getName())
                        .idnumber(category.getIdnumber())
                        .description(category.getDescription())
                        .descriptionformat(category.getDescriptionformat())
                        .parent(category.getParent())
                        .sortorder(category.getSortorder())
                        .coursecount(category.getCoursecount())
                        .visible(category.getVisible())
                        .visibleold(category.getVisibleold())
                        .timemodified(category.getTimemodified())
                        .depth(category.getDepth())
                        .path(category.getPath())
                        .theme(category.getTheme())
                        .children(new ArrayList<>())
                        .build()));

        // Construir la jerarquía recursiva
        List<RecursiveCategory> rootCategories = new ArrayList<>();
        for (RecursiveCategory category : categoryMap.values()) {
            if (Objects.equals(category.getParent(), 0L)) {
                // Es una categoría raíz
                rootCategories.add(category);
            } else {
                // Agregar como hijo de su padre
                RecursiveCategory parent = categoryMap.get(category.getParent());
                if (parent != null) {
                    parent.getChildren().add(category);
                }
            }
        }

        return rootCategories;
    }
}