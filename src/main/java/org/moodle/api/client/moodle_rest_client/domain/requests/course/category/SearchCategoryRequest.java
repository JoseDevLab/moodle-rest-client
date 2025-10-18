package org.moodle.api.client.moodle_rest_client.domain.requests.course.category;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SearchCategoryRequest {
    private Boolean addSubCategories;
    private List<SearchCriterion> criteria;
}
