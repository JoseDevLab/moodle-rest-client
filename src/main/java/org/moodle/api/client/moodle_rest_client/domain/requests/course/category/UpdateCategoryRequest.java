package org.moodle.api.client.moodle_rest_client.domain.requests.course.category;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateCategoryRequest {
    private Long id;
    private String name;
    private String idnumber;
    private String description;
    private String descriptionFormat;
    private String theme;
    private Boolean visible;
}
