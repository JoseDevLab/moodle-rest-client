package org.moodle.api.client.moodle_rest_client.application.services.user;

import lombok.RequiredArgsConstructor;
import org.moodle.api.client.moodle_rest_client.domain.models.Warning;
import org.moodle.api.client.moodle_rest_client.domain.ports.in.user.CreateUsersUseCase;
import org.moodle.api.client.moodle_rest_client.domain.ports.in.user.GetUsersUseCase;
import org.moodle.api.client.moodle_rest_client.domain.ports.in.user.UpdateUsersUseCase;
import org.moodle.api.client.moodle_rest_client.domain.ports.out.user.UserPort;
import org.moodle.api.client.moodle_rest_client.domain.requests.user.CreateUserRequest;
import org.moodle.api.client.moodle_rest_client.domain.requests.user.SearchUserCriterion;
import org.moodle.api.client.moodle_rest_client.domain.requests.user.UpdateUserRequest;
import org.moodle.api.client.moodle_rest_client.domain.responses.user.CreateUserResponse;
import org.moodle.api.client.moodle_rest_client.domain.responses.user.UserSearchResponse;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements GetUsersUseCase, CreateUsersUseCase, UpdateUsersUseCase {

    private final UserPort userPort;

    @Override
    public UserSearchResponse getUsers(List<SearchUserCriterion> criteria) {
        return userPort.getUsers(criteria);
    }

    @Override
    public List<CreateUserResponse> createUsers(List<CreateUserRequest> usersToCreate) {
        return userPort.createUsers(usersToCreate);
    }

    @Override
    public List<Warning> updateUsers(List<UpdateUserRequest> usersToUpdate) {
        return userPort.updateUsers(usersToUpdate);
    }
}