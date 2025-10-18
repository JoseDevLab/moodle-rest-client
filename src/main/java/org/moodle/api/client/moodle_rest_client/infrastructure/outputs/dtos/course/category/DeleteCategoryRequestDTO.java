package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.course.category;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeleteCategoryRequestDTO {
    private Long id;
    private boolean recursive;
}
