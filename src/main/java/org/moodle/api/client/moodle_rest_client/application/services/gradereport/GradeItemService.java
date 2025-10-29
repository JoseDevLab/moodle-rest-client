package org.moodle.api.client.moodle_rest_client.application.services.gradereport;

import lombok.RequiredArgsConstructor;
import org.moodle.api.client.moodle_rest_client.domain.ports.in.gradereport.user.GetGradeItemsUseCase;
import org.moodle.api.client.moodle_rest_client.domain.ports.out.gradereport.GradeItemPort;
import org.moodle.api.client.moodle_rest_client.domain.requests.gradereport.user.GetGradeItemsRequest;
import org.moodle.api.client.moodle_rest_client.domain.responses.gradereport.gradeItem.GradeItems;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.gradereport.user.GetGradeItemsRequestDTO;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GradeItemService implements GetGradeItemsUseCase {

    private final GradeItemPort gradeItemPort;

    @Override
    public GradeItems getUserGradeItems(Long courseId) {
        return gradeItemPort.getUserGradeItems(courseId);
    }

    @Override
    public GradeItems getUserGradeItems(GetGradeItemsRequest request) {
        return gradeItemPort.getUserGradeItems(request);
    }
}