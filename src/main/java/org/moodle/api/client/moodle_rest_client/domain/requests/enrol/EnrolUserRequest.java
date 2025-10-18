package org.moodle.api.client.moodle_rest_client.domain.requests.enrol;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EnrolUserRequest {
    private Integer roleid;
    private Integer userid;
    private Integer courseid;
    private Long timestart;
    private Long timeend;
    private Integer suspend;
}
