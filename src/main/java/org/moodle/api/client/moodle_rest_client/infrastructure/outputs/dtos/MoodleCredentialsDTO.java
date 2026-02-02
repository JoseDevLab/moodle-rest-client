package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MoodleCredentialsDTO {
    private String url;
    private String wstoken;
}
