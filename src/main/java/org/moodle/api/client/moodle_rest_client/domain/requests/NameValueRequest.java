package org.moodle.api.client.moodle_rest_client.domain.requests;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NameValueRequest {
    String name;
    String value;
}
