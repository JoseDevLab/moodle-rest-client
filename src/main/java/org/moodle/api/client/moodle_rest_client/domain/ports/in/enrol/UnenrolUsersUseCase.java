package org.moodle.api.client.moodle_rest_client.domain.ports.in.enrol;

import org.moodle.api.client.moodle_rest_client.domain.exceptions.MoodleApiException;
import org.moodle.api.client.moodle_rest_client.domain.requests.enrol.UnenrolUserRequest;

import java.util.List;

public interface UnenrolUsersUseCase {
    void unenrolUsers(List<UnenrolUserRequest> enrolments) throws MoodleApiException;
}
