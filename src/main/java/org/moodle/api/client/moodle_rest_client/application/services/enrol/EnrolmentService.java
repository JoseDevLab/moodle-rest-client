package org.moodle.api.client.moodle_rest_client.application.services.enrol;

import lombok.RequiredArgsConstructor;
import org.moodle.api.client.moodle_rest_client.domain.models.EnrolledUser;
import org.moodle.api.client.moodle_rest_client.domain.models.MoodleCredentials;
import org.moodle.api.client.moodle_rest_client.domain.ports.in.enrol.EnrolUsersUseCase;
import org.moodle.api.client.moodle_rest_client.domain.ports.in.enrol.GetEnrolledUsersUseCase;
import org.moodle.api.client.moodle_rest_client.domain.ports.in.enrol.UnenrolUsersUseCase;
import org.moodle.api.client.moodle_rest_client.domain.ports.out.enrol.EnrolmentPort;
import org.moodle.api.client.moodle_rest_client.domain.requests.enrol.EnrolUserRequest;
import org.moodle.api.client.moodle_rest_client.domain.requests.enrol.GetEnrolledUsersOption;
import org.moodle.api.client.moodle_rest_client.domain.requests.enrol.UnenrolUserRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnrolmentService implements EnrolUsersUseCase, UnenrolUsersUseCase, GetEnrolledUsersUseCase {

    private final EnrolmentPort enrolmentPort;

    @Override
    public void enrolUsers(MoodleCredentials moodleCredentials, List<EnrolUserRequest> enrolments) {
        enrolmentPort.enrolUsers(moodleCredentials, enrolments);
    }

    @Override
    public void unenrolUsers(MoodleCredentials moodleCredentials, List<UnenrolUserRequest> enrolments) {
        enrolmentPort.unenrolUsers(moodleCredentials, enrolments);
    }

    @Override
    public List<EnrolledUser> getEnrolledUsers(MoodleCredentials moodleCredentials, Integer courseid, List<GetEnrolledUsersOption> options) {
        return enrolmentPort.getEnrolledUsers(moodleCredentials, courseid, options);
    }

    @Override
    public List<EnrolledUser> getEnrolledUsers(MoodleCredentials moodleCredentials, Integer courseid) {
        return enrolmentPort.getEnrolledUsers(moodleCredentials, courseid);
    }
}
