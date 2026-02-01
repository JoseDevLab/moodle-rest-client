package org.moodle.api.client.moodle_rest_client.domain.ports.out.user;

import org.moodle.api.client.moodle_rest_client.domain.exceptions.MoodleApiException;
import org.moodle.api.client.moodle_rest_client.domain.models.Warning;
import org.moodle.api.client.moodle_rest_client.domain.requests.user.CreateUserRequest;
import org.moodle.api.client.moodle_rest_client.domain.requests.user.SearchUserCriterion;
import org.moodle.api.client.moodle_rest_client.domain.requests.user.UpdateUserRequest;
import org.moodle.api.client.moodle_rest_client.domain.responses.user.CreateUserResponse;
import org.moodle.api.client.moodle_rest_client.domain.responses.user.UserSearchResponse;
import org.moodle.api.client.moodle_rest_client.domain.models.MoodleCredentials;

import java.util.List;

public interface UserPort {
    UserSearchResponse getUsers(MoodleCredentials moodleCredentials, List<SearchUserCriterion> criteria) throws MoodleApiException;
    List<CreateUserResponse> createUsers(MoodleCredentials moodleCredentials, List<CreateUserRequest> usersToCreate) throws MoodleApiException;
    List<Warning> updateUsers(MoodleCredentials moodleCredentials, List<UpdateUserRequest> usersToUpdate) throws MoodleApiException;
}
