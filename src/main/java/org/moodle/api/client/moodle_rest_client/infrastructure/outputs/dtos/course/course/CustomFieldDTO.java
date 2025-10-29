package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.course.course;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomFieldDTO {
    private String name;
    @JsonProperty("shortname")
    private String shortName;
    private String type;
    @JsonProperty("valueraw")
    private String valueRaw;
    private String value;
}
