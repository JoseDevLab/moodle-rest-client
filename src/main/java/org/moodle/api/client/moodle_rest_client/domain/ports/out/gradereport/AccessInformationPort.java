package org.moodle.api.client.moodle_rest_client.domain.ports.out.gradereport;

import org.moodle.api.client.moodle_rest_client.domain.responses.gradereport.user.AccessInformation;
import org.moodle.api.client.moodle_rest_client.domain.models.MoodleCredentials;

public interface AccessInformationPort {
    public AccessInformation getAccessInformation(MoodleCredentials moodleCredentials, Long courseId);
}
