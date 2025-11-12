package org.moodle.api.client.moodle_rest_client.domain.ports.out.user;

import org.moodle.api.client.moodle_rest_client.domain.exceptions.MoodleApiException;
import org.moodle.api.client.moodle_rest_client.domain.models.Warning;
import org.moodle.api.client.moodle_rest_client.domain.requests.user.CreateUserRequest;
import org.moodle.api.client.moodle_rest_client.domain.requests.user.SearchUserCriterion;
import org.moodle.api.client.moodle_rest_client.domain.requests.user.UpdateUserRequest;
import org.moodle.api.client.moodle_rest_client.domain.responses.user.CreateUserResponse;
import org.moodle.api.client.moodle_rest_client.domain.responses.user.UserSearchResponse;

import java.util.List;

public interface UserPort {
    UserSearchResponse getUsers(List<SearchUserCriterion> criteria) throws MoodleApiException;
    List<CreateUserResponse> createUsers(List<CreateUserRequest> usersToCreate) throws MoodleApiException;
    List<Warning> updateUsers(List<UpdateUserRequest> usersToUpdate) throws MoodleApiException;
}
