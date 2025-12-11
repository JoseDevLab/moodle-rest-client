package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.webservice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdvancedFeatureDTO {
    private String name;
    private Integer value;
}
