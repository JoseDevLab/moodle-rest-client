package org.moodle.api.client.moodle_rest_client.domain.ports.out.gradereport;

import org.moodle.api.client.moodle_rest_client.domain.exceptions.MoodleApiException;
import org.moodle.api.client.moodle_rest_client.domain.requests.gradereport.user.GetGradeItemsRequest;
import org.moodle.api.client.moodle_rest_client.domain.responses.gradereport.gradeItem.GradeItems;
import org.moodle.api.client.moodle_rest_client.domain.models.MoodleCredentials;

public interface GradeItemPort {
    GradeItems getUserGradeItems(MoodleCredentials moodleCredentials, Long courseId) throws MoodleApiException;
    GradeItems getUserGradeItems(MoodleCredentials moodleCredentials, GetGradeItemsRequest request) throws MoodleApiException;
}
