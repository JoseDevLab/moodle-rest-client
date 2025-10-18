package org.moodle.api.client.moodle_rest_client.domain.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Group {
    private Integer id;
    private String name;
    private String description;
    private Integer descriptionformat;
}
