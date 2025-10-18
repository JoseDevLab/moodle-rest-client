package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.gradereport.gradeitem;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserGradeDTO {
    @JsonProperty("courseid")
    private Long courseId;
    @JsonProperty("courseidnumber")
    private String courseIdNumber;
    @JsonProperty("userid")
    private Long userId;
    @JsonProperty("userfullname")
    private String userFullName;
    @JsonProperty("useridnumber")
    private String userIdNumber;
    @JsonProperty("maxdepth")
    private int maxDepth;
    @JsonProperty("gradeitems")
    private List<GradeItemDTO> gradeItems;
}
