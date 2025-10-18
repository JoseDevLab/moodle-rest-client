package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.config;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class MoodleApiConfig {
    private String apiUrl;
    private String apiToken;
}
