package org.moodle.api.client.moodle_rest_client.application.services.reportbuilder;

import lombok.RequiredArgsConstructor;
import org.moodle.api.client.moodle_rest_client.domain.exceptions.MoodleApiException;
import org.moodle.api.client.moodle_rest_client.domain.models.MoodleCredentials;
import org.moodle.api.client.moodle_rest_client.domain.ports.in.reportbuilder.RetrieveSystemReportUseCase;
import org.moodle.api.client.moodle_rest_client.domain.ports.out.reportbuilder.RetrieveSystemReportPort;
import org.moodle.api.client.moodle_rest_client.domain.requests.reportbuilder.RetrieveSystemReportRequest;
import org.moodle.api.client.moodle_rest_client.domain.responses.reportbuilder.RetrieveSystemReport;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RetrieveSystemReportService implements RetrieveSystemReportUseCase {
    private final RetrieveSystemReportPort retrieveSystemReportPort;

    @Override
    public RetrieveSystemReport execute(MoodleCredentials moodleCredentials, RetrieveSystemReportRequest request) throws MoodleApiException {
        return retrieveSystemReportPort.execute(moodleCredentials, request);
    }
}
