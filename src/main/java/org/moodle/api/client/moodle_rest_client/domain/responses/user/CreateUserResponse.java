package org.moodle.api.client.moodle_rest_client.domain.responses.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateUserResponse {
    private Long id;
    private String username;
}
