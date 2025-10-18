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

import java.util.List;

public interface CoursePort {
    List<Course> createCourses(List<CreateCourseRequest> coursesToCreate) throws MoodleApiException;
    List<Course> searchCoursesByField(String field, String value) throws MoodleApiException;
    void updateCourses(List<UpdateCourseRequest> coursesToUpdate) throws MoodleApiException;
    void deleteCourses(List<Long> courseIds) throws MoodleApiException;
    List<Section> getCourseContents(Long courseId) throws MoodleApiException;
    CourseModule getCourseModule(Long courseModuleId) throws MoodleApiException;
    CourseSearch searchCourses(String searchText, int page, int perPage) throws MoodleApiException;
    List<Course> getCoursesById(List<Long> courseIds) throws MoodleApiException;
    Course duplicateCourse(DuplicateCourseRequest request) throws MoodleApiException;
    void importCourse(ImportCourseRequest request) throws MoodleApiException;
}
