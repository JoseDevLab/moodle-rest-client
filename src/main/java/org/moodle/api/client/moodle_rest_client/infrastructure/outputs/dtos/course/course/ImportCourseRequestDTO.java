package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.course.course;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImportCourseRequestDTO {
    private Long importfrom;
    private Long importto;
    private Integer deletecontent;
    List<ImportOptionRequestDTO> options;
}
