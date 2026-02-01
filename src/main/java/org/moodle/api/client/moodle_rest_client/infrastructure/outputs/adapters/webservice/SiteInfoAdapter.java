package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.adapters.webservice;

import lombok.RequiredArgsConstructor;
import org.moodle.api.client.moodle_rest_client.domain.exceptions.MoodleApiException;
import org.moodle.api.client.moodle_rest_client.domain.models.MoodleCredentials;
import org.moodle.api.client.moodle_rest_client.domain.models.SiteInfo;
import org.moodle.api.client.moodle_rest_client.domain.ports.out.webservice.SiteInfoPort;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.client.MoodleHttpClient;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.webservice.SiteInfoDTO;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.mappers.MoodleCredentialsMapper;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.mappers.webservice.SiteInfoMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SiteInfoAdapter implements SiteInfoPort {

    private final MoodleHttpClient moodleHttpClient;
    private final SiteInfoMapper siteInfoMapper;
    private final MoodleCredentialsMapper moodleCredentialsMapper;

    private static final String GET_SITE_INFO_FUNCTION = "core_webservice_get_site_info";

    @Override
    public SiteInfo getSiteInfo(MoodleCredentials moodleCredentials) throws MoodleApiException {
        SiteInfoDTO dto = moodleHttpClient.call(
                moodleCredentialsMapper.toDTO(moodleCredentials),
                GET_SITE_INFO_FUNCTION,
                null,
                SiteInfoDTO.class
        );
        return siteInfoMapper.toDomain(dto);
    }
}
