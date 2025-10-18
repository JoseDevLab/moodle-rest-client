package org.moodle.api.client.moodle_rest_client.domain.requests.course.category;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateCategoryRequest {
    private String name;
    private Long parent;
    private String idnumber;
    private String description;
    private Integer descriptionFormat;
    private String theme;
}