package org.moodle.api.client.moodle_rest_client.domain.ports.in.course.course;

import org.moodle.api.client.moodle_rest_client.domain.exceptions.MoodleApiException;
import org.moodle.api.client.moodle_rest_client.domain.models.Section;

import java.util.List;

public interface GetCourseContentsUseCase {
    List<Section> getCourseContents(Long courseId) throws MoodleApiException;
}
