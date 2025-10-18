package org.moodle.api.client.moodle_rest_client.domain.requests.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchUserCriterion {
    private String key;
    private String value;
}