package org.moodle.api.client.moodle_rest_client.domain.ports.in.course.course;

import org.moodle.api.client.moodle_rest_client.domain.exceptions.MoodleApiException;
import org.moodle.api.client.moodle_rest_client.domain.models.Course;
import org.moodle.api.client.moodle_rest_client.domain.models.MoodleCredentials;

import java.util.List;

public interface GetCoursesByFieldUseCase {
    /**
     *
     * @param moodleCredentials
     * @param field string  Valor por defecto para "" //The field to search can be left empty for all courses or:
     *                     id: course id
     *                     ids: comma separated course ids
     *                     shortname: course short name
     *                     idnumber: course id number
     *                     category: category id the course belongs to
     *                     sectionid: section id that belongs to a course
     * @param value string  Valor por defecto para "" //The value to match
     * @return
     * @throws MoodleApiException
     */
    List<Course> getCoursesByField(MoodleCredentials moodleCredentials, String field, String value) throws MoodleApiException;
}
