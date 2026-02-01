package org.moodle.api.client.moodle_rest_client.application.services.course;

import lombok.RequiredArgsConstructor;
import org.moodle.api.client.moodle_rest_client.domain.models.Course;
import org.moodle.api.client.moodle_rest_client.domain.models.CourseModule;
import org.moodle.api.client.moodle_rest_client.domain.models.MoodleCredentials;
import org.moodle.api.client.moodle_rest_client.domain.models.Section;
import org.moodle.api.client.moodle_rest_client.domain.ports.in.course.course.*;
import org.moodle.api.client.moodle_rest_client.domain.ports.out.course.CoursePort;
import org.moodle.api.client.moodle_rest_client.domain.requests.course.course.CreateCourseRequest;
import org.moodle.api.client.moodle_rest_client.domain.requests.course.course.DuplicateCourseRequest;
import org.moodle.api.client.moodle_rest_client.domain.requests.course.course.ImportCourseRequest;
import org.moodle.api.client.moodle_rest_client.domain.requests.course.course.UpdateCourseRequest;
import org.moodle.api.client.moodle_rest_client.domain.responses.course.category.CourseSearch;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService implements CreateCoursesUseCase, GetCoursesByFieldUseCase, UpdateCoursesUseCase, DeleteCoursesUseCase, GetCourseContentsUseCase, GetCourseModuleUseCase, SearchCoursesUseCase, GetCoursesByIdUseCase, DuplicateCourseUseCase, ImportCourseUseCase {

    private final CoursePort coursePort;

    @Override
    public List<Course> createCourses(MoodleCredentials moodleCredentials, List<CreateCourseRequest> coursesToCreate) {
        return coursePort.createCourses(moodleCredentials, coursesToCreate);
    }

    @Override
    public List<Course> getCoursesByField(MoodleCredentials moodleCredentials, String field, String value) {
        return coursePort.searchCoursesByField(moodleCredentials, field, value);
    }

    @Override
    public void updateCourses(MoodleCredentials moodleCredentials, List<UpdateCourseRequest> coursesToUpdate) {
        coursePort.updateCourses(moodleCredentials, coursesToUpdate);
    }

    @Override
    public void deleteCourses(MoodleCredentials moodleCredentials, List<Long> courseIds) {
        coursePort.deleteCourses(moodleCredentials, courseIds);
    }

    @Override
    public List<Section> getCourseContents(MoodleCredentials moodleCredentials, Long courseId) {
        return coursePort.getCourseContents(moodleCredentials, courseId);
    }

    @Override
    public CourseModule getCourseModule(MoodleCredentials moodleCredentials, Long courseModuleId) {
        return coursePort.getCourseModule(moodleCredentials, courseModuleId);
    }

    @Override
    public CourseSearch searchCourses(MoodleCredentials moodleCredentials, String searchText, int page, int perPage) {
        return coursePort.searchCourses(moodleCredentials, searchText, page, perPage);
    }

    @Override
    public List<Course> getCoursesById(MoodleCredentials moodleCredentials, List<Long> courseIds) {
        return coursePort.getCoursesById(moodleCredentials, courseIds);
    }

    @Override
    public Course duplicateCourse(MoodleCredentials moodleCredentials, DuplicateCourseRequest request) {
        return coursePort.duplicateCourse(moodleCredentials, request);
    }

    @Override
    public void importCourse(MoodleCredentials moodleCredentials, ImportCourseRequest request) {
        coursePort.importCourse(moodleCredentials, request);
    }
}