package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.mappers.course;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.moodle.api.client.moodle_rest_client.domain.models.Category;
import org.moodle.api.client.moodle_rest_client.domain.requests.course.category.*;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.course.category.*;

import java.util.List;

@Mapper
public interface CategoryMapper {
    default int map(boolean value) {
        return value ? 1 : 0;
    }
    default boolean map(int value) {
        return value == 1;
    }
    default Integer map(Boolean value) { return value == null ? null : value ? 1 : 0;}
    default Boolean map(Integer value) { return value == null ? null : value == 1;}

    Category toDomain(CategoryDTO dto);

    List<Category> toDomain(CategoryDTO[] dtos);

    @Mapping(source = "descriptionFormat", target = "descriptionformat")
    CreateCategoryRequestDTO toRequestDTO(CreateCategoryRequest domainRequest);

    List<CreateCategoryRequestDTO> toRequestDTO(List<CreateCategoryRequest> domainRequests);

    @Mapping(source = "descriptionFormat", target = "descriptionformat")
    UpdateCategoryRequestDTO toRequestDTO(UpdateCategoryRequest domainRequest);

    List<UpdateCategoryRequestDTO> toUpdateDTO(List<UpdateCategoryRequest> domainRequests);

    DeleteCategoryRequestDTO toRequestDTO(DeleteCategoryRequest domainRequest);

    List<DeleteCategoryRequestDTO> toDeleteDTO(List<DeleteCategoryRequest> domainRequests);

    SearchCriterionDTO toRequestDTO(SearchCriterion domainRequest);




    @Mapping(source = "addSubCategories", target = "addsubcategories")
    SearchCategoryRequestDTO toRequestDTO(SearchCategoryRequest domainRequest);

    List<SearchCriterionDTO> toSearchDTO(List<SearchCriterion> domainRequests);
}
