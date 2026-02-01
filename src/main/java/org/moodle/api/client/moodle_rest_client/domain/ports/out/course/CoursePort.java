package org.moodle.api.client.moodle_rest_client.domain.ports.out.course;

import org.moodle.api.client.moodle_rest_client.domain.exceptions.MoodleApiException;
import org.moodle.api.client.moodle_rest_client.domain.models.Course;
import org.moodle.api.client.moodle_rest_client.domain.models.CourseModule;
import org.moodle.api.client.moodle_rest_client.domain.models.Section;
import org.moodle.api.client.moodle_rest_client.domain.requests.course.course.CreateCourseRequest;
import org.moodle.api.client.moodle_rest_client.domain.requests.course.course.DuplicateCourseRequest;
import org.moodle.api.client.moodle_rest_client.domain.requests.course.course.ImportCourseRequest;
import org.moodle.api.client.moodle_rest_client.domain.requests.course.course.UpdateCourseRequest;
import org.moodle.api.client.moodle_rest_client.domain.responses.course.category.CourseSearch;
import org.moodle.api.client.moodle_rest_client.domain.models.MoodleCredentials;

import java.util.List;

public interface CoursePort {
    List<Course> createCourses(MoodleCredentials moodleCredentials, List<CreateCourseRequest> coursesToCreate) throws MoodleApiException;
    List<Course> searchCoursesByField(MoodleCredentials moodleCredentials, String field, String value) throws MoodleApiException;
    void updateCourses(MoodleCredentials moodleCredentials, List<UpdateCourseRequest> coursesToUpdate) throws MoodleApiException;
    void deleteCourses(MoodleCredentials moodleCredentials, List<Long> courseIds) throws MoodleApiException;
    List<Section> getCourseContents(MoodleCredentials moodleCredentials, Long courseId) throws MoodleApiException;
    CourseModule getCourseModule(MoodleCredentials moodleCredentials, Long courseModuleId) throws MoodleApiException;
    CourseSearch searchCourses(MoodleCredentials moodleCredentials, String searchText, int page, int perPage) throws MoodleApiException;
    List<Course> getCoursesById(MoodleCredentials moodleCredentials, List<Long> courseIds) throws MoodleApiException;
    Course duplicateCourse(MoodleCredentials moodleCredentials, DuplicateCourseRequest request) throws MoodleApiException;
    void importCourse(MoodleCredentials moodleCredentials, ImportCourseRequest request) throws MoodleApiException;
}
