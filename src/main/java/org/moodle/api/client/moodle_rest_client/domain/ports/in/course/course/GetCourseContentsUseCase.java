package org.moodle.api.client.moodle_rest_client.domain.ports.in.course.course;

import org.moodle.api.client.moodle_rest_client.domain.exceptions.MoodleApiException;
import org.moodle.api.client.moodle_rest_client.domain.models.Section;
import org.moodle.api.client.moodle_rest_client.domain.models.MoodleCredentials;

import java.util.List;

public interface GetCourseContentsUseCase {
    List<Section> getCourseContents(MoodleCredentials moodleCredentials, Long courseId) throws MoodleApiException;
}
