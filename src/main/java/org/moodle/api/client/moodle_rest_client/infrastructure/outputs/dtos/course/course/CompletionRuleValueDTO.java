package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.course.course;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.deserializers.IntegerOrAnythingDeserializer;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompletionRuleValueDTO {
    @JsonDeserialize(using = IntegerOrAnythingDeserializer.class)
    private Integer status;
    private String description;
}