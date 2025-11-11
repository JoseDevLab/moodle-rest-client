package org.moodle.api.client.moodle_rest_client.application.services.course;

import lombok.RequiredArgsConstructor;
import org.moodle.api.client.moodle_rest_client.domain.models.Course;
import org.moodle.api.client.moodle_rest_client.domain.models.CourseModule;
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
    public List<Course> createCourses(List<CreateCourseRequest> coursesToCreate) {
        return coursePort.createCourses(coursesToCreate);
    }

    @Override
    public List<Course> getCoursesByField(String field, String value) {
        return coursePort.searchCoursesByField(field, value);
    }

    @Override
    public void updateCourses(List<UpdateCourseRequest> coursesToUpdate) {
        coursePort.updateCourses(coursesToUpdate);
    }

    @Override
    public void deleteCourses(List<Long> courseIds) {
        coursePort.deleteCourses(courseIds);
    }

    @Override
    public List<Section> getCourseContents(Long courseId) {
        return coursePort.getCourseContents(courseId);
    }

    @Override
    public CourseModule getCourseModule(Long courseModuleId) {
        return coursePort.getCourseModule(courseModuleId);
    }

    @Override
    public CourseSearch searchCourses(String searchText, int page, int perPage) {
        return coursePort.searchCourses(searchText, page, perPage);
    }

    @Override
    public List<Course> getCoursesById(List<Long> courseIds) {
        return coursePort.getCoursesById(courseIds);
    }

    @Override
    public Course duplicateCourse(DuplicateCourseRequest request) {
        return coursePort.duplicateCourse(request);
    }

    @Override
    public void importCourse(ImportCourseRequest request) {
        coursePort.importCourse(request);
    }
}