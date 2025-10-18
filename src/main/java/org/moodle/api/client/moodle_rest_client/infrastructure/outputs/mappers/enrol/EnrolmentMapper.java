package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.mappers.enrol;

import org.mapstruct.Mapper;
import org.moodle.api.client.moodle_rest_client.domain.models.EnrolledCourse;
import org.moodle.api.client.moodle_rest_client.domain.models.EnrolledUser;
import org.moodle.api.client.moodle_rest_client.domain.models.Group;
import org.moodle.api.client.moodle_rest_client.domain.models.Role;
import org.moodle.api.client.moodle_rest_client.domain.requests.enrol.EnrolUserRequest;
import org.moodle.api.client.moodle_rest_client.domain.requests.enrol.GetEnrolledUsersOption;
import org.moodle.api.client.moodle_rest_client.domain.requests.enrol.UnenrolUserRequest;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.enrol.*;

import java.util.List;

@Mapper
public interface EnrolmentMapper {
    EnrolUserRequestDTO toRequestDTO(EnrolUserRequest request);
    List<EnrolUserRequestDTO> toRequestDTO(List<EnrolUserRequest> requests);

    UnenrolUserRequestDTO toRequestDTO(UnenrolUserRequest request);
    List<UnenrolUserRequestDTO> toUnenrolRequestDTO(List<UnenrolUserRequest> requests);

    GetEnrolledUsersOptionDTO toRequestDTO(GetEnrolledUsersOption option);
    List<GetEnrolledUsersOptionDTO> toOptionRequestDTO(List<GetEnrolledUsersOption> options);

    EnrolledUser toDomain(EnrolledUserDTO dto);
    List<EnrolledUser> toEnrolledUserDomain(List<EnrolledUserDTO> dtos);

    Group toDomain(GroupDTO dto);
    Role toDomain(RoleDTO dto);
    EnrolledCourse toDomain(EnrolledCourseDTO dto);
}
