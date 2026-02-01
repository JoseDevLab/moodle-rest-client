package org.moodle.api.client.moodle_rest_client.domain.ports.in.webservice;

import org.moodle.api.client.moodle_rest_client.domain.exceptions.MoodleApiException;
import org.moodle.api.client.moodle_rest_client.domain.models.MoodleCredentials;
import org.moodle.api.client.moodle_rest_client.domain.models.SiteInfo;

public interface GetSiteInfoUseCase {
    SiteInfo getSiteInfo(MoodleCredentials moodleCredentials) throws MoodleApiException;
}
