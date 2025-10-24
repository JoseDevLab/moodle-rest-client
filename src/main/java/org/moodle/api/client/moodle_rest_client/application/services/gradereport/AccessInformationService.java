package org.moodle.api.client.moodle_rest_client.application.services.gradereport;

import lombok.RequiredArgsConstructor;
import org.moodle.api.client.moodle_rest_client.domain.ports.in.gradereport.user.GetAccessInformationUseCase;
import org.moodle.api.client.moodle_rest_client.domain.ports.out.gradereport.AccessInformationPort;
import org.moodle.api.client.moodle_rest_client.domain.responses.gradereport.user.AccessInformation;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccessInformationService implements GetAccessInformationUseCase {

    private final AccessInformationPort accessInformationPort;

    @Override
    public AccessInformation getAccessInformation(Long courseId) {
        return accessInformationPort.getAccessInformation(courseId);
    }
}
