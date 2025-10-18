package org.moodle.api.client.moodle_rest_client.domain.models;

import lombok.Builder;
import lombok.Data;
import org.moodle.api.client.moodle_rest_client.domain.responses.course.course.CompletionDetail;

import java.util.List;

@Data
@Builder
public class CompletionData {
    private Integer state;
    private Integer timecompleted;
    private Integer overrideby;
    private Integer valueused;
    private Integer hascompletion;
    private Integer isautomatic;
    private Integer istrackeduser;
    private Integer uservisible;
    private List<CompletionDetail> details;
    private Integer isoverallcomplete;
}
