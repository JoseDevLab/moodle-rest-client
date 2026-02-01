package org.moodle.api.client.moodle_rest_client.domain.ports.out;

import org.moodle.api.client.moodle_rest_client.domain.requests.mod.assign.GetGradesRequest;
import org.moodle.api.client.moodle_rest_client.domain.responses.mod.assign.Grades;
import org.moodle.api.client.moodle_rest_client.domain.models.MoodleCredentials;

public interface GradePort {
    Grades getGrades(MoodleCredentials moodleCredentials, GetGradesRequest dto);
}
