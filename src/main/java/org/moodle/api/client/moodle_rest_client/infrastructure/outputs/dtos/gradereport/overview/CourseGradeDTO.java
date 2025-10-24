package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.gradereport.overview;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CourseGradeDTO {
    @JsonProperty("courseid")
    private Integer courseId;
    @JsonProperty("grade")
    private String grade;
    @JsonProperty("rawgrade")
    private String rawGrade;
    @JsonProperty("rank")
    private Integer rank;
}