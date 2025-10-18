package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.gradereport.gradeitem;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.WarningDTO;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserGradesResponseDTO {
    @JsonProperty("usergrades")
    private List<UserGradeDTO> userGrades;
    @JsonProperty("warnings")
    private List<WarningDTO> warnings;
}