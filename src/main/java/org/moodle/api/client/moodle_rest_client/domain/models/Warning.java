package org.moodle.api.client.moodle_rest_client.domain.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Warning {
    private String item;
    private Long itemId;
    private String warningCode;
    private String message;
}
