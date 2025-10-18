package org.moodle.api.client.moodle_rest_client.domain.ports.in.gradereport.gradeitem;

import org.moodle.api.client.moodle_rest_client.domain.exceptions.MoodleApiException;
import org.moodle.api.client.moodle_rest_client.domain.responses.gradereport.gradeItem.GradeItems;

public interface GetUserGradeItemsUseCase {
    GradeItems getUserGradeItems(Long courseId) throws MoodleApiException;
}
