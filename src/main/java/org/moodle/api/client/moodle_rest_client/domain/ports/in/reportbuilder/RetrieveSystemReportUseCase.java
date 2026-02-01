package org.moodle.api.client.moodle_rest_client.domain.ports.in.reportbuilder;

import org.moodle.api.client.moodle_rest_client.domain.exceptions.MoodleApiException;
import org.moodle.api.client.moodle_rest_client.domain.models.MoodleCredentials;
import org.moodle.api.client.moodle_rest_client.domain.requests.reportbuilder.RetrieveSystemReportRequest;
import org.moodle.api.client.moodle_rest_client.domain.responses.reportbuilder.RetrieveSystemReport;

public interface RetrieveSystemReportUseCase {
    RetrieveSystemReport execute(MoodleCredentials moodleCredentials, RetrieveSystemReportRequest request) throws MoodleApiException;
}
