package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.mod.assign;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GradeDTO {
    private Long id;
    private Long assignment;
    private Long userid;
    private Integer attemptnumber;
    private Integer timecreated;
    private Integer timemodified;
    private Integer grader;
    private String grade;
    private String gradefordisplay;
}
