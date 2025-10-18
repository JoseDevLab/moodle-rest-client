package org.moodle.api.client.moodle_rest_client.domain.responses.user;

import lombok.Builder;
import lombok.Data;
import org.moodle.api.client.moodle_rest_client.domain.models.User;
import org.moodle.api.client.moodle_rest_client.domain.models.Warning;

import java.util.List;

@Data
@Builder
public class UserSearchResponse {
    private List<User> users;
    private List<Warning> warnings;
}