package org.moodle.api.client.moodle_rest_client.application.services.gradereport;

import lombok.RequiredArgsConstructor;
import org.moodle.api.client.moodle_rest_client.domain.ports.in.gradereport.overview.GetCourseGradesUseCase;
import org.moodle.api.client.moodle_rest_client.domain.ports.out.gradereport.CourseGradePort;
import org.moodle.api.client.moodle_rest_client.domain.responses.gradereport.overview.CourseGrades;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseGradeService implements GetCourseGradesUseCase {

    private final CourseGradePort courseGradePort;

    @Override
    public CourseGrades getCourseGrades(Integer userId) {
        return courseGradePort.getCourseGrades(userId);
    }
}