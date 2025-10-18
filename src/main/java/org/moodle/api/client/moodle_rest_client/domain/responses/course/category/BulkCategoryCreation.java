package org.moodle.api.client.moodle_rest_client.domain.responses.course.category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.moodle.api.client.moodle_rest_client.domain.models.Category;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BulkCategoryCreation {
    private List<Category> successfulCategories;
    private List<FailedCategoryCreation> failedCreations;
}
