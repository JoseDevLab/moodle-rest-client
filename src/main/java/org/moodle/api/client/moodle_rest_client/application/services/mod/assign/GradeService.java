package org.moodle.api.client.moodle_rest_client.application.services.mod.assign;

import lombok.RequiredArgsConstructor;
import org.moodle.api.client.moodle_rest_client.domain.models.MoodleCredentials;
import org.moodle.api.client.moodle_rest_client.domain.ports.in.mod.assign.GetGradesUseCase;
import org.moodle.api.client.moodle_rest_client.domain.ports.out.GradePort;
import org.moodle.api.client.moodle_rest_client.domain.requests.mod.assign.GetGradesRequest;
import org.moodle.api.client.moodle_rest_client.domain.responses.mod.assign.Grades;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GradeService implements GetGradesUseCase {

    private final GradePort gradePort;

    @Override
    public Grades getGrades(MoodleCredentials moodleCredentials, GetGradesRequest request) {
        return gradePort.getGrades(moodleCredentials, request);
    }
}
