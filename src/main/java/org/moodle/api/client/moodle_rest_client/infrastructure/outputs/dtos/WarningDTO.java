package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WarningDTO {
    private String item;
    @JsonProperty("itemid")
    private Long itemId;
    @JsonProperty("warningcode")
    private String warningCode;
    private String message;
}
