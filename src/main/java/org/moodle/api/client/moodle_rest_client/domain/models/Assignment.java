package org.moodle.api.client.moodle_rest_client.domain.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Assignment {
    private Long assignmentid;
    private List<Grade> grades;
}
