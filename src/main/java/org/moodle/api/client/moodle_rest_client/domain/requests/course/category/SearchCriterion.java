package org.moodle.api.client.moodle_rest_client.domain.requests.course.category;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchCriterion {
    private String key;
    private String value;
}
