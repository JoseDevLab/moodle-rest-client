
package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchUserCriterionDTO {
    private String key;
    private String value;
}