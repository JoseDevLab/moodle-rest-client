package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.gradereport.overview;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.WarningDTO;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CourseGradesResponseDTO {
    @JsonProperty("grades")
    private List<CourseGradeDTO> grades;
    @JsonProperty("warnings")
    private List<WarningDTO> warnings;
}