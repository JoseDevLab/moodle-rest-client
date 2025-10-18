package org.moodle.api.client.moodle_rest_client.domain.ports.in.enrol;

import org.moodle.api.client.moodle_rest_client.domain.exceptions.MoodleApiException;
import org.moodle.api.client.moodle_rest_client.domain.requests.enrol.EnrolUserRequest;

import java.util.List;

public interface EnrolUsersUseCase {
    void enrolUsers(List<EnrolUserRequest> enrolments) throws MoodleApiException;
}
