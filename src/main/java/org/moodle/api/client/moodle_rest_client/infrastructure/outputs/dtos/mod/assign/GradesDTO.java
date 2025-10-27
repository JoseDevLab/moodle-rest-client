package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.mod.assign;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.WarningDTO;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GradesDTO {
    private List<AssignmentDTO> assignments;
    private List<WarningDTO> warnings;
}
