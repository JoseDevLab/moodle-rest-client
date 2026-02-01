package org.moodle.api.client.moodle_rest_client.domain.ports.in.user;

import org.moodle.api.client.moodle_rest_client.domain.exceptions.MoodleApiException;
import org.moodle.api.client.moodle_rest_client.domain.models.MoodleCredentials;
import org.moodle.api.client.moodle_rest_client.domain.requests.user.SearchUserCriterion;
import org.moodle.api.client.moodle_rest_client.domain.responses.user.UserSearchResponse;

import java.util.List;

public interface GetUsersUseCase {
    UserSearchResponse getUsers(MoodleCredentials moodleCredentials, List<SearchUserCriterion> criteria) throws MoodleApiException;
}