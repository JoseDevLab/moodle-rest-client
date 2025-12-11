package org.moodle.api.client.moodle_rest_client.application.services.webservice;

import lombok.RequiredArgsConstructor;
import org.moodle.api.client.moodle_rest_client.domain.exceptions.MoodleApiException;
import org.moodle.api.client.moodle_rest_client.domain.models.SiteInfo;
import org.moodle.api.client.moodle_rest_client.domain.ports.in.webservice.GetSiteInfoUseCase;
import org.moodle.api.client.moodle_rest_client.domain.ports.out.webservice.SiteInfoPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SiteInfoService implements GetSiteInfoUseCase {

    private final SiteInfoPort siteInfoPort;

    @Override
    public SiteInfo getSiteInfo() throws MoodleApiException {
        return siteInfoPort.getSiteInfo();
    }
}
