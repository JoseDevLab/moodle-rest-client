package org.moodle.api.client.moodle_rest_client.domain.ports.in.user;

import org.moodle.api.client.moodle_rest_client.domain.exceptions.MoodleApiException;
import org.moodle.api.client.moodle_rest_client.domain.requests.user.CreateUserRequest;
import org.moodle.api.client.moodle_rest_client.domain.responses.user.CreateUserResponse;

import java.util.List;

public interface CreateUsersUseCase {
    List<CreateUserResponse> createUsers(List<CreateUserRequest> usersToCreate) throws MoodleApiException;
}
