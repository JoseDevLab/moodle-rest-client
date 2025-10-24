package org.moodle.api.client.moodle_rest_client.domain.ports.out.gradereport;

import org.moodle.api.client.moodle_rest_client.domain.responses.gradereport.user.AccessInformation;

public interface AccessInformationPort {
    public AccessInformation getAccessInformation(Long courseId);
}
