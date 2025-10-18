package org.moodle.api.client.moodle_rest_client.domain.requests.course.category;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeleteCategoryRequest {
    private Long id;
    private boolean recursive;
}
