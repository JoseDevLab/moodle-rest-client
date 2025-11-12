package org.moodle.api.client.moodle_rest_client.domain.ports.in.user;

import org.moodle.api.client.moodle_rest_client.domain.models.Warning;
import org.moodle.api.client.moodle_rest_client.domain.requests.user.UpdateUserRequest;

import java.util.List;

public interface UpdateUsersUseCase {
    List<Warning> updateUsers(List<UpdateUserRequest> usersToUpdate);
}
