package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.course.category;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateCategoryRequestDTO {
    private Long id;
    private String name;
    private String idnumber;
    private String description;
    private String descriptionformat;
    private String theme;
    private Boolean visible;
}
