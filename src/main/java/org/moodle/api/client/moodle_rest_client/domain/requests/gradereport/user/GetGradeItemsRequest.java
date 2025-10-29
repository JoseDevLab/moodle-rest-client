package org.moodle.api.client.moodle_rest_client.domain.requests.gradereport.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetGradeItemsRequest {
    private Long courseid;
    private Long userid;
    private Long groupid;
}
