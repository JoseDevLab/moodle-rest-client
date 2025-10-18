package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateUserResponseDTO {
    private Long id;
    private String username;
}
