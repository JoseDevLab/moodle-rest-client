package org.moodle.api.client.moodle_rest_client.domain.ports.in.enrol;

import org.moodle.api.client.moodle_rest_client.domain.exceptions.MoodleApiException;
import org.moodle.api.client.moodle_rest_client.domain.models.EnrolledUser;
import org.moodle.api.client.moodle_rest_client.domain.requests.enrol.GetEnrolledUsersOption;

import java.util.List;

public interface GetEnrolledUsersUseCase {
    List<EnrolledUser> getEnrolledUsers(Integer courseid, List<GetEnrolledUsersOption> options) throws MoodleApiException;
    List<EnrolledUser> getEnrolledUsers(Integer sourseid) throws MoodleApiException;
}
