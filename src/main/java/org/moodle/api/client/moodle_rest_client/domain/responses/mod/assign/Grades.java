package org.moodle.api.client.moodle_rest_client.domain.responses.mod.assign;

import lombok.Builder;
import lombok.Data;
import org.moodle.api.client.moodle_rest_client.domain.models.Assignment;
import org.moodle.api.client.moodle_rest_client.domain.models.Warning;

import java.util.List;

@Data
@Builder
public class Grades {
    private List<Assignment> assignments;
    private List<Warning> warnings;
}
