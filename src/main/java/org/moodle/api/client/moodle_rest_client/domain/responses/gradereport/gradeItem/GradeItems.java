package org.moodle.api.client.moodle_rest_client.domain.responses.gradereport.gradeItem;

import lombok.Builder;
import lombok.Data;
import org.moodle.api.client.moodle_rest_client.domain.models.UserGrade;
import org.moodle.api.client.moodle_rest_client.domain.models.Warning;

import java.util.List;

@Data
@Builder
public class GradeItems {
    private List<UserGrade> userGrades;
    private List<Warning> warnings;
}
