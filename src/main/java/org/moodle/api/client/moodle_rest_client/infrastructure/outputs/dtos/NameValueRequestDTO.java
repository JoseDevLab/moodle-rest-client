package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NameValueRequestDTO {
    String name;
    String value;
}
