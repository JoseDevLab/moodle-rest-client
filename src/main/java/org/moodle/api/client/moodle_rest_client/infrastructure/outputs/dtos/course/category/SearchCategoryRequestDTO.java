package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.course.category;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SearchCategoryRequestDTO {
    private Integer addsubcategories;
    private List<SearchCriterionDTO> criteria;
}
