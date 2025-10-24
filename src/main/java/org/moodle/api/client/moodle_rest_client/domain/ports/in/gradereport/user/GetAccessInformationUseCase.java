package org.moodle.api.client.moodle_rest_client.domain.ports.in.gradereport.user;

import org.moodle.api.client.moodle_rest_client.domain.responses.gradereport.user.AccessInformation;

public interface GetAccessInformationUseCase {
    public AccessInformation getAccessInformation(Long courseId);
}
