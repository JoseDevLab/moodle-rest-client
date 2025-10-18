package org.moodle.api.client.moodle_rest_client.domain.requests.enrol;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetEnrolledUsersOption {
    private String name;
    private String value;
}
