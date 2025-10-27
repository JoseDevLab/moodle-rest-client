package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.mod.assign;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AssignmentDTO {
    private Long assignmentid;
    private List<GradeDTO> grades;
}
