package org.moodle.api.client.moodle_rest_client.domain.ports.in.gradereport.user;

import org.moodle.api.client.moodle_rest_client.domain.exceptions.MoodleApiException;
import org.moodle.api.client.moodle_rest_client.domain.requests.gradereport.user.GetGradeItemsRequest;
import org.moodle.api.client.moodle_rest_client.domain.responses.gradereport.gradeItem.GradeItems;

public interface GetGradeItemsUseCase {
    GradeItems getUserGradeItems(Long courseId) throws MoodleApiException;
    GradeItems getUserGradeItems(GetGradeItemsRequest request) throws MoodleApiException;
}
