package org.moodle.api.client.moodle_rest_client.domain.ports.out.enrol;

import org.moodle.api.client.moodle_rest_client.domain.exceptions.MoodleApiException;
import org.moodle.api.client.moodle_rest_client.domain.models.EnrolledUser;
import org.moodle.api.client.moodle_rest_client.domain.requests.enrol.EnrolUserRequest;
import org.moodle.api.client.moodle_rest_client.domain.requests.enrol.GetEnrolledUsersOption;
import org.moodle.api.client.moodle_rest_client.domain.requests.enrol.UnenrolUserRequest;
import org.moodle.api.client.moodle_rest_client.domain.models.MoodleCredentials;

import java.util.List;

public interface EnrolmentPort {
    void enrolUsers(MoodleCredentials moodleCredentials, List<EnrolUserRequest> enrolments) throws MoodleApiException;
    void unenrolUsers(MoodleCredentials moodleCredentials, List<UnenrolUserRequest> enrolments) throws MoodleApiException;
    List<EnrolledUser> getEnrolledUsers(MoodleCredentials moodleCredentials, Integer courseid, List<GetEnrolledUsersOption> options) throws MoodleApiException;
    List<EnrolledUser> getEnrolledUsers(MoodleCredentials moodleCredentials, Integer courseid) throws MoodleApiException;
}
