package org.moodle.api.client.moodle_rest_client.domain.requests.course.category;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RecursiveCategoryRequest {
    private String name;
    private String idnumber;
    private String description;
    private Integer descriptionformat;
    private String theme;
    private List<RecursiveCategoryRequest> children;
}
