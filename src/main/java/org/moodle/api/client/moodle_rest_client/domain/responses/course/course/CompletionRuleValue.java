package org.moodle.api.client.moodle_rest_client.domain.responses.course.course;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CompletionRuleValue {
    private Integer status;
    private String description;
}