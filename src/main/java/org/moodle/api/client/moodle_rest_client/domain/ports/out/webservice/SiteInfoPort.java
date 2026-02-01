package org.moodle.api.client.moodle_rest_client.domain.ports.out.webservice;

import org.moodle.api.client.moodle_rest_client.domain.exceptions.MoodleApiException;
import org.moodle.api.client.moodle_rest_client.domain.models.SiteInfo;
import org.moodle.api.client.moodle_rest_client.domain.models.MoodleCredentials;

public interface SiteInfoPort {
    SiteInfo getSiteInfo(MoodleCredentials moodleCredentials) throws MoodleApiException;
}
