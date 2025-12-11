package org.moodle.api.client.moodle_rest_client.domain.ports.out.webservice;

import org.moodle.api.client.moodle_rest_client.domain.exceptions.MoodleApiException;
import org.moodle.api.client.moodle_rest_client.domain.models.SiteInfo;

public interface SiteInfoPort {
    SiteInfo getSiteInfo() throws MoodleApiException;
}
