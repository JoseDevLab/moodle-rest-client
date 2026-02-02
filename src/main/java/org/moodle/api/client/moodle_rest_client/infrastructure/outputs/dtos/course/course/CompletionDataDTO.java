package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.course.course;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.deserializers.IntegerOrAnythingDeserializer;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompletionDataDTO {
    private Integer state;
    @JsonDeserialize(using = IntegerOrAnythingDeserializer.class)
    private Integer timecompleted;
    @JsonDeserialize(using = IntegerOrAnythingDeserializer.class)
    private Integer overrideby;
    @JsonDeserialize(using = IntegerOrAnythingDeserializer.class)
    private Integer valueused;
    @JsonDeserialize(using = IntegerOrAnythingDeserializer.class)
    private Integer hascompletion;
    @JsonDeserialize(using = IntegerOrAnythingDeserializer.class)
    private Integer isautomatic;
    @JsonDeserialize(using = IntegerOrAnythingDeserializer.class)
    private Integer istrackeduser;
    @JsonDeserialize(using = IntegerOrAnythingDeserializer.class)
    private Integer uservisible;
    private List<CompletionDetailDTO> details;
    @JsonDeserialize(using = IntegerOrAnythingDeserializer.class)
    private Integer isoverallcomplete;
}
