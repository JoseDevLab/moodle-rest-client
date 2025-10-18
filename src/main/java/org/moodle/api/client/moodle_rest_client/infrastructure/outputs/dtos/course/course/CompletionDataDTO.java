package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.course.course;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompletionDataDTO {
    private Integer state;
    @JsonProperty("timecompleted")
    private Integer timecompleted;
    @JsonProperty("overrideby")
    private Integer overrideby;
    @JsonProperty("valueused")
    private Integer valueused;
    private Integer hascompletion;
    private Integer isautomatic;
    private Integer istrackeduser;
    private Integer uservisible;
    private List<CompletionDetailDTO> details;
    private Integer isoverallcomplete;
}
