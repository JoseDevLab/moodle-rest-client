package org.moodle.api.client.moodle_rest_client.domain.requests.course.course;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ImportCourseRequest {
    private Long importfrom;
    private Long importto;
    private Boolean deletecontent;
    List<ImportOptionRequest> options;
}
