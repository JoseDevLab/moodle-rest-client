package org.moodle.api.client.moodle_rest_client.application.services.gradereport;

import lombok.RequiredArgsConstructor;
import org.moodle.api.client.moodle_rest_client.domain.ports.in.gradereport.gradeitem.GetUserGradeItemsUseCase;
import org.moodle.api.client.moodle_rest_client.domain.ports.out.gradereport.GradeItemPort;
import org.moodle.api.client.moodle_rest_client.domain.responses.gradereport.gradeItem.GradeItems;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GradeItemService implements GetUserGradeItemsUseCase {

    private final GradeItemPort gradeItemPort;

    @Override
    public GradeItems getUserGradeItems(Long courseId) {
        return gradeItemPort.getUserGradeItems(courseId);
    }
}