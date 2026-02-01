package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MoodleCredentialsDTO {
    private String url;
    private String wstoken;
}
