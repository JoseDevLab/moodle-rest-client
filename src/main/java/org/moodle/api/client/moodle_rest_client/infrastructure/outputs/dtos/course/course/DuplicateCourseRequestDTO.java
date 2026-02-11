package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.course.course;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.NameValueRequestDTO;

import java.util.List;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class DuplicateCourseRequestDTO {
    private Long courseid;
    private String fullname;
    private String shortname;
    private Long categoryid;
    private Integer visible;
    List<NameValueRequestDTO> options;
}
