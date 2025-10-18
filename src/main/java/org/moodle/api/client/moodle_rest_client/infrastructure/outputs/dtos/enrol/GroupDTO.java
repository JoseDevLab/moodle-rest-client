package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.enrol;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GroupDTO {
    private Integer id;
    private String name;
    private String description;
    private Integer descriptionformat;
}
