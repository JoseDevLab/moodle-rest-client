package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.gradereport.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetGradeItemsRequestDTO {
    private Long courseid;
    private Long userid;
    private Long groupid;
}
