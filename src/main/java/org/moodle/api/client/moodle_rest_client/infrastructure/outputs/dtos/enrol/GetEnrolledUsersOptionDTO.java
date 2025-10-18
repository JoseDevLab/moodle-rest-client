package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.enrol;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetEnrolledUsersOptionDTO {
    private String name;
    private String value;
}
