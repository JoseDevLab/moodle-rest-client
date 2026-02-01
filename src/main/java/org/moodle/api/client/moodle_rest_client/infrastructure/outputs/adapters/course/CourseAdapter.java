package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.adapters.course;

import lombok.RequiredArgsConstructor;
import org.moodle.api.client.moodle_rest_client.domain.models.Course;
import org.moodle.api.client.moodle_rest_client.domain.models.CourseModule;
import org.moodle.api.client.moodle_rest_client.domain.models.MoodleCredentials;
import org.moodle.api.client.moodle_rest_client.domain.models.Section;
import org.moodle.api.client.moodle_rest_client.domain.ports.out.course.CoursePort;
import org.moodle.api.client.moodle_rest_client.domain.requests.course.course.CreateCourseRequest;
import org.moodle.api.client.moodle_rest_client.domain.requests.course.course.DuplicateCourseRequest;
import org.moodle.api.client.moodle_rest_client.domain.requests.course.course.ImportCourseRequest;
import org.moodle.api.client.moodle_rest_client.domain.requests.course.course.UpdateCourseRequest;
import org.moodle.api.client.moodle_rest_client.domain.responses.course.category.CourseSearch;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.client.MoodleHttpClient;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.course.course.*;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.mappers.MoodleCredentialsMapper;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.mappers.course.CourseMapper;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CourseAdapter implements CoursePort {

    private final MoodleHttpClient moodleHttpClient;
    private final CourseMapper courseMapper;
    private final MoodleCredentialsMapper moodleCredentialsMapper;
    private final com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();

    private static final String CREATE_COURSES_FUNCTION = "core_course_create_courses";
    private static final String GET_COURSES_BY_FIELD_FUNCTION = "core_course_get_courses_by_field";
    private static final String UPDATE_COURSES_FUNCTION = "core_course_update_courses";
    private static final String DELETE_COURSES_FUNCTION = "core_course_delete_courses";
    private static final String GET_COURSE_CONTENTS_FUNCTION = "core_course_get_contents";
    private static final String GET_COURSE_MODULE_FUNCTION = "core_course_get_course_module";
    private static final String SEARCH_COURSES_FUNCTION = "core_course_search_courses";
    private static final String GET_COURSES_FUNCTION = "core_course_get_courses";
    private static final String DUPLICATE_COURSE_FUNCTION = "core_course_duplicate_course";
    private static final String IMPORT_COURSE_FUNCTION = "core_course_import_course";

    @Override
    public List<Course> createCourses(MoodleCredentials moodleCredentials, List<CreateCourseRequest> coursesToCreate) {
        List<CreateCourseRequestDTO> dtoList = coursesToCreate.stream()
                .map(courseMapper::toRequestDTO)
                .collect(Collectors.toList());

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("courses", dtoList);

        CourseDTO[] createdCourses = moodleHttpClient.call(
                moodleCredentialsMapper.toDTO(moodleCredentials),
                CREATE_COURSES_FUNCTION,
                requestBody,
                CourseDTO[].class
        );

        if (createdCourses == null) {
            return Collections.emptyList();
        }

        return courseMapper.toDomain(Arrays.asList(createdCourses));
    }

    @Override
    public List<Course> searchCoursesByField(MoodleCredentials moodleCredentials, String field, String value) {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("field", field);
        requestBody.put("value", value);

        GetCoursesByFieldResponseDTO response = moodleHttpClient.call(
                moodleCredentialsMapper.toDTO(moodleCredentials),
                GET_COURSES_BY_FIELD_FUNCTION,
                requestBody,
                GetCoursesByFieldResponseDTO.class
        );

        if (response == null || response.getCourses() == null) {
            return Collections.emptyList();
        }

        return courseMapper.toDomain(response.getCourses());
    }

    @Override
    public void updateCourses(MoodleCredentials moodleCredentials, List<UpdateCourseRequest> coursesToUpdate) {
        List<UpdateCourseRequestDTO> dtoList = coursesToUpdate.stream()
                .map(courseMapper::toRequestDTO)
                .collect(Collectors.toList());

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("courses", dtoList);

        moodleHttpClient.call(
                moodleCredentialsMapper.toDTO(moodleCredentials),
                UPDATE_COURSES_FUNCTION,
                requestBody,
                Void.class
        );
    }


    @Override
    public void deleteCourses(MoodleCredentials moodleCredentials, List<Long> courseIds) {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("courseids", courseIds);

        moodleHttpClient.call(
                moodleCredentialsMapper.toDTO(moodleCredentials),
                DELETE_COURSES_FUNCTION,
                requestBody,
                Void.class
        );
    }


    @Override
    public List<Section> getCourseContents(MoodleCredentials moodleCredentials, Long courseId) {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("courseid", courseId.toString());

        SectionDTO[] response = moodleHttpClient.call(
                moodleCredentialsMapper.toDTO(moodleCredentials),
                GET_COURSE_CONTENTS_FUNCTION,
                requestBody,
                SectionDTO[].class
        );

        if (response == null) {
            return Collections.emptyList();
        }

        return courseMapper.toSectionDomain(Arrays.asList(response));
    }

    @Override
    public CourseModule getCourseModule(MoodleCredentials moodleCredentials, Long courseModuleId) {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("cmid", courseModuleId.toString());

        GetCourseModuleResponseDTO response = moodleHttpClient.call(
                moodleCredentialsMapper.toDTO(moodleCredentials),
                GET_COURSE_MODULE_FUNCTION,
                requestBody,
                GetCourseModuleResponseDTO.class
        );

        if (response == null || response.getCourseModule() == null) {
            return null;
        }

        return courseMapper.toDomain(response.getCourseModule());
    }

    @Override
    public CourseSearch searchCourses(MoodleCredentials moodleCredentials, String searchText, int page, int perPage) {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("criterianame", "search");
        requestBody.put("criteriavalue", searchText);
        requestBody.put("page", page);
        requestBody.put("perpage", perPage);

        CourseSearchResponseDTO response = moodleHttpClient.call(
                moodleCredentialsMapper.toDTO(moodleCredentials),
                SEARCH_COURSES_FUNCTION,
                requestBody,
                CourseSearchResponseDTO.class
        );


        if (response == null) {
            return CourseSearch.builder().courses(Collections.emptyList()).total(0).build();
        }

        return courseMapper.toDomain(response);
    }

    @Override
    public List<Course> getCoursesById(MoodleCredentials moodleCredentials, List<Long> courseIds) {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("options[ids]", courseIds);

        CourseDTO[] response = moodleHttpClient.call(
                moodleCredentialsMapper.toDTO(moodleCredentials),
                GET_COURSES_FUNCTION,
                requestBody,
                CourseDTO[].class
        );

        if (response == null) {
            return Collections.emptyList();
        }

        return courseMapper.toDomain(Arrays.asList(response));
    }

    @Override
    @SuppressWarnings("unchecked")
    public Course duplicateCourse(MoodleCredentials moodleCredentials, DuplicateCourseRequest request) {
        DuplicateCourseRequestDTO requestDTO = courseMapper.toRequestDTO(request);
        // El cuerpo de la petición es directamente el DTO, no un mapa
        CourseDTO response = moodleHttpClient.call(
                moodleCredentialsMapper.toDTO(moodleCredentials),
                DUPLICATE_COURSE_FUNCTION,
                (Map<String, Object>) objectMapper.convertValue(requestDTO, Map.class),
                CourseDTO.class
        );

        return courseMapper.toDomain(response);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void importCourse(MoodleCredentials moodleCredentials, ImportCourseRequest request) {
        ImportCourseRequestDTO requestDTO = courseMapper.toRequestDTO(request);
        moodleHttpClient.call(
                moodleCredentialsMapper.toDTO(moodleCredentials),
                IMPORT_COURSE_FUNCTION,
                (Map<String, Object>) objectMapper.convertValue(requestDTO, Map.class),
                Void.class
        );
    }
}
