package org.moodle.api.client.moodle_rest_client.domain.requests.mod.assign;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetGradesRequest {
    private List<Integer> assignmentids;
    private Integer since;
}
