package org.moodle.api.client.moodle_rest_client.domain.ports.in.mod.assign;

import org.moodle.api.client.moodle_rest_client.domain.requests.mod.assign.GetGradesRequest;
import org.moodle.api.client.moodle_rest_client.domain.responses.mod.assign.Grades;

public interface GetGradesUseCase {
    Grades getGrades(GetGradesRequest request);
}
