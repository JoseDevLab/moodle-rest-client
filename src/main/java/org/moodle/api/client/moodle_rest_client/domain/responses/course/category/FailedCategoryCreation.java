package org.moodle.api.client.moodle_rest_client.domain.responses.course.category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.moodle.api.client.moodle_rest_client.domain.requests.course.category.RecursiveCategoryRequest;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FailedCategoryCreation {
    private RecursiveCategoryRequest request;
    private Throwable throwable;
    private String failureReason;
}
