package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.enrol;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnrolUserRequestDTO {
    private Integer roleid;
    private Integer userid;
    private Integer courseid;
    private Long timestart;
    private Long timeend;
    private Integer suspend;
}
